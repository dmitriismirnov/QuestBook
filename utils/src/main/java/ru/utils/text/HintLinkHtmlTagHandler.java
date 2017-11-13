package ru.utils.text;

import android.graphics.Color;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.xml.sax.XMLReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * a
 * Created by deler on 11.05.16.
 */
public class HintLinkHtmlTagHandler implements Html.TagHandler {


    public static void setLinkHint(JsonObject link, TextView textLabel, boolean isBlueLink, UrlClickListener listener) {
        setLinkHint(link, "link", textLabel, isBlueLink, listener);
    }

    public static void setLinkHint(JsonObject link, String tagName, TextView textLabel, boolean isBlueLink, UrlClickListener listener) {
        if (link == null) {
            textLabel.setText("");
        } else {
            String rawText = link.get(tagName).getAsString();
            rawText = rawText.replaceAll("'", "\"");
            rawText = rawText.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("\\u003c", "<").replaceAll("\\u003e", ">");
            Map<String, String> linkMap = new HashMap<>();
            Set<Map.Entry<String, JsonElement>> entries = link.entrySet();
            boolean hasLink = false;
            for (Map.Entry<String, JsonElement> entry : entries) {
                if (entry.getKey().equalsIgnoreCase(tagName)) {
                    continue;
                }
                hasLink = true;
                JsonElement value = entry.getValue();
                linkMap.put(entry.getKey(), value.isJsonArray() || value.isJsonObject() ? value.toString() : value.getAsString());
            }
            textLabel.setText(Html.fromHtml(rawText, null, new HintLinkHtmlTagHandler(linkMap, listener, isBlueLink)));
            if (hasLink) {
                textLabel.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

//    private static String getLink(String url) {
//        String domain = ContactsManager.instance().getContacts().getWebSite();
//        return domain + url;
//    }

    private Map<String, String> linkMap;
    private UrlClickListener urlClickListener;
    private boolean isBlueLink = false;

    private Map<String, Stack<CustomTag>> stackMap = new HashMap<>();

    public HintLinkHtmlTagHandler(Map<String, String> linkMap, UrlClickListener urlClickListener, boolean isBlueLink) {
        this.linkMap = linkMap;
        this.urlClickListener = urlClickListener;
        this.isBlueLink = isBlueLink;
    }

    @Override
    public void handleTag(final boolean opening, final String tag, Editable output, final XMLReader xmlReader) {

        if (linkMap.containsKey(tag)) {
            String url = linkMap.get(tag);
            if (opening) {
                Stack<CustomTag> tagStack = stackMap.get(tag);
                if (tagStack == null) {
                    tagStack = new Stack<>();
                    stackMap.put(tag, tagStack);
                }
                tagStack.push(new CustomTag(output.length(), new LinkSpan(url, urlClickListener, isBlueLink)));
            } else {
                CharSequence symbols = FontUtils.getSymbols("→");

                Stack<CustomTag> tagStack = stackMap.get(tag);
                CustomTag customTag = tagStack.pop();
                output.append(TextUtils.concat(" ", symbols, " "));
                output.setSpan(customTag.getSpan(), customTag.getStart(), output.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }

    private static class CustomTag {
        private int start;
        private CharacterStyle span;

        public CustomTag(int start, CharacterStyle span) {
            this.start = start;
            this.span = span;
        }

        public int getStart() {
            return start;
        }

        public CharacterStyle getSpan() {
            return span;
        }
    }

    private static class LinkSpan extends ClickableSpan {

        int linkColor;
        private final String url;
        private UrlClickListener urlClickListener;

        public LinkSpan(String url, UrlClickListener urlClickListener, boolean isBlueLink) {
            this.url = url;
            this.urlClickListener = urlClickListener;
            linkColor = isBlueLink ? Color.parseColor("#ff1567bc") : Color.parseColor("#333333");
        }

        @Override
        public void onClick(View widget) {
            if (urlClickListener != null) {
                urlClickListener.onUrlClick(url);
            }
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
            ds.setColor(linkColor);
        }
    }

    public interface UrlClickListener {
        void onUrlClick(String url);
    }
}
