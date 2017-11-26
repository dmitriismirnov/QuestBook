package ru.utils.security;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import ru.utils.LogUtils;
import ru.utils.stream.StreamUtils;


public class RootDetectionUtils {
    private static final String TAG = "";

    public static boolean isDeviceRooted() {

        boolean m1 = checkRootMethod1();
        boolean m2 = checkRootMethod2();
        boolean m3 = checkRootMethod3();

        return (m1 || m2 || m3);
    }


    private static boolean checkRootMethod1() {
        String buildTags = android.os.Build.TAGS;
        return buildTags != null && buildTags.contains("test-keys");
    }

    private static boolean checkRootMethod2() {
        String[] paths = { "/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su",
                "/system/bin/failsafe/su", "/data/local/su" };
        for (String path : paths) {
            if (new File(path).exists()) return true;
        }
        return false;
    }

    private static boolean checkRootMethod3() {
        if (new ExecShell().executeCommand(ExecShell.SHELL_CMD.check_su_binary) != null) {
            LogUtils.d(TAG, "ROOT CHECK : We are root as [su] binary file was found on the device");
            return true;
        } else {
            return false;
        }
    }

    public static class ExecShell {
        private static String LOG_TAG = ExecShell.class.getName();

        public enum SHELL_CMD {
            check_su_binary(new String[]{"/system/xbin/which", "su"});
            String[] command;

            SHELL_CMD(String[] command) {
                this.command = command;
            }
        }

        public ArrayList<String> executeCommand(SHELL_CMD shellCmd) {
            String line = null;
            ArrayList<String> fullResponse = new ArrayList<String>();
            Process localProcess = null;
            try {
                localProcess = Runtime.getRuntime().exec(shellCmd.command);
            } catch (Exception e) {
                return null;
            }
            OutputStream os = null;
            OutputStreamWriter osw = null;
            BufferedWriter out = null;
            InputStream is = null;
            InputStreamReader isr = null;
            BufferedReader in = null;
            try {
                os = localProcess.getOutputStream();
                osw = new OutputStreamWriter(os);
                out = new BufferedWriter(osw);
                is = localProcess.getInputStream();
                isr = new InputStreamReader(is);
                in = new BufferedReader(isr);
                while ((line = in.readLine()) != null) {
                    fullResponse.add(line);
                }
            } catch (Throwable th) {
                LogUtils.e(LOG_TAG, th);
            } finally {
                StreamUtils.close(out);
                out = null;
                StreamUtils.close(osw);
                osw = null;
                StreamUtils.close(os);
                os = null;
                StreamUtils.close(in);
                in = null;
                StreamUtils.close(isr);
                isr = null;
                StreamUtils.close(is);
                is = null;
            }
            LogUtils.d(LOG_TAG, "--> Full response was: " + fullResponse);
            return fullResponse;
        }
    }
}



