package ru.utils.data;


public final class JsonKeys {

    //REGISTRATION KEYS
    public static final String JSON_HAS_FINGERPRINT_HARDWARE = "hasFingerprintHardware";

    public static final String JSON_WATERMARK = "watermark";
    public static final String JSON_CLOSING_ACTION = "closingAction";
    public static final String JSON_VK = "vk";
    public static final String JSON_FB = "fb";
    public static final String JSON_OK = "ok";
    public static final String JSON_BANK_LOGO_NAME = "logoName";
    public static final String JSON_BANK_MESSAGE = "welcomeMessage";
    public static final String JSON_BUTTON_CONTROL = "bottomControl";
    public static final String JSON_TEXT_COLOR = "textColor";

    // endpoint
    public static final String JSON_ENVIRONMENTS = "environments";
    public static final String JSON_ENDPOINT = "endpoint";
    public static final String JSON_ENDPOINT_ARRAY = "endpoints";

    public static final String JSON_TAG = "tag";
    public static final String JSON_URI = "uri";

    // login
    public static final String JSON_DOMAIN = "domain";

    public static final String JSON_USERNAME = "username";

    // FIXME: code refactoring is needed
    public static final String JSON_CARD_NUMBER = "card_number";
    public static final String JSON_ACCOUNT_NUMBER = "account_number";
    public static final String JSON_ACCESS_CODE = "access_code";
    public static final String JSON_CONFIRMATION_CODE = "confirmation_code";
    public static final String JSON_CONFIRM_PASSWORD = "confirm_password";
    public static final String JSON_PASSWORD_CONFIRMATION = "passwordconfirmation";
    public static final String JSON_OFFER_LOCATION = "offerLocation";
    public static final String JSON_MAPPED_SERVICE_NEW_CARD = "newCard";
    public static final String JSON_MAPPED_SERVICE_NEW_WALLET = "newWallet";
    public static final String JSON_MAPPED_SERVICE_NEW_LOAN = "newLoan";

    public static final String JSON_PAST_PERIOD = "pastPeriod";
    public static final String JSON_FUTURE_PERIOD = "futurePeriod";
    public static final String JSON_TIMELINE_CONFIGURATION = "timelineConfiguration";
// -- constants (network)

    // contacts
    public static final String JSON_CONTACTS = "contacts";

    public static final String JSON_EMAIL = "email";
    public static final String JSON_PHONE_NUMBER = "phone";
    public static final String JSON_ALTERNATIVE_PHONE_NUMBER = "alternativePhone";
    public static final String JSON_WEB_SITE = "web";
//  public static final String JSON_LINKS = "links";

    public static final String JSON_SERVICE_TYPE_SHOPPER_PACKAGE = "shopperpackage";
// --

    // json api
    public static final String JSON_CODE = "code";
    public static final String JSON_OTP = "otp";
    public static final String JSON_PAN = "pan";
    public static final String JSON_NAME = "name";
    public static final String JSON_MASK = "mask";
    public static final String JSON_VALUE = "value";
    public static final String JSON_LOGINS = "logins";
    public static final String JSON_OPTIONS = "options";
    public static final String JSON_NEWS_MAIL = "newsmail";
    public static final String JSON_ACCOUNT_ACCESS_CODE = "accountaccesscode";
    public static final String JSON_HINT = "hint";
    public static final String JSON_CURRENT_VALUE = "currentValue";
    public static final String JSON_SET_LIMIT_VALUE = "setLimitValue";
    public static final String JSON_MAX_LIMIT_VALUE = "maxLimitValue";
    public static final String JSON_AVAILABLE_AMOUNT = "availableAmount";
    public static final String JSON_CAN_INPUT_AMOUNT = "canInputAmount";
    public static final String JSON_CAN_RESET = "canReset";

    // user
    public static final String JSON_MSISDN = "msisdn";
    public static final String JSON_OWNER = "owner";
    public static final String JSON_MOBILE_SECONDARY = "mobileSecondary";
    public static final String JSON_EMAIL_SECONDARY = "emailSecondary";
    public static final String JSON_FAVORITE_CARD_ID = "favoriteCardId";
    public static final String JSON_HOME_LOCALITY = "homeLocality";

    // dashboard
    public static final String JSON_IS_HIDDEN = "hidden";
    public static final String JSON_ADVICE = "advice";
    public static final String JSON_PLANNED_EXPENSE = "plannedExpense";
    public static final String JSON_DATE = "date";
    public static final String JSON_AMOUNT = "amount";
    public static final String JSON_HAS_DEPOSITS = "hasDeposits";
    public static final String JSON_DEPOSIT_AMOUNT = "depositAmount";
    public static final String JSON_IMPORTANT_EVENTS_COUNT = "importantEventCount";
    public static final String JSON_UNREAD_MESSAGE_COUNT = "unreadMessageCount";

    public static final String JSON_MASTER_ACCOUNT = "masterAccount";

    public static final String JSON_CARD_CONTRACTS = "cardContracts";
    public static final String JSON_LOAN_CONTRACTS = "loanContracts";
    public static final String JSON_DEPOSIT_CONTRACTS = "depositContracts";
    public static final String JSON_GOAL_CONTRACTS = "goalContracts";
    public static final String JSON_WALLET_CONTRACTS = "walletContracts";
    public static final String JSON_THIRD_PARTY_CARDS = "thirdpartycards";

    public static final String JSON_ITEMS = "items";
    public static final String JSON_ACCOUNTS = "accounts";
    public static final String JSON_CARDS = "cards";
    public static final String JSON_CATEGORIES = "categories";
    public static final String JSON_ACTIONS = "actions";

    public static final String JSON_DISPLAY_NAME = "displayName";
    public static final String JSON_OPENED_DATE = "openedDate";
    public static final String JSON_SIGNING_DATE = "signingDate";
    public static final String JSON_CLOSED_DATE = "closedDate";
    public static final String JSON_CLOSING_DATE = "closingDate";

    public static final String JSON_ORIGINAL_INTEREST_RATE = "originalInterestRate";
    public static final String JSON_INTEREST_RATE = "interestRate";
    public static final String JSON_P2P = "p2p";

    public static final String JSON_HAS_OVERDUE = "hasOverdue";
    public static final String JSON_OVERDUE_INFO = "overdueInfo";
    public static final String JSON_OVERDUE_AMOUNT = "overdueAmount";
    public static final String JSON_DEBT_OVERDUE_AMOUNT = "debtOverdueAmount";
    public static final String JSON_OVERDUE_PAYMENTS_COUNT = "overduePaymentsCount";
    public static final String JSON_OVERDUE_PAYMENTS_AMOUNT = "overduePaymentsAmount";
    public static final String JSON_INTEREST_OVERDUE_AMOUNT = "interestOverdueAmount";

    public static final String JSON_PAYMENT_DUE_DATE = "paymentDueDate";
    public static final String JSON_PAYMENT_DUE_AMOUNT = "paymentDueAmount";
    public static final String JSON_PAYMENT_DUE_AMOUNT_REST = "paymentDueAmountRest";

    public static final String JSON_LIMIT_CLOSED = "limitClosed";
    public static final String JSON_LIMIT_BLOCKED = "limitBlocked";
    public static final String JSON_LIMIT_CLOSING_DATE = "limitClosingDate";
    public static final String JSON_AVAILABLE_LIMIT_AMOUNT = "availableLimitAmount";
    public static final String JSON_TOTAL_AVAILABLE_AMOUNT = "totalAvailableAmount";
    public static final String JSON_MAX_AMOUNT_RESTRICTION = "maxAmountRestriction";

    public static final String JSON_NUMBER = "number";
    public static final String JSON_STATE = "state";
    public static final String JSON_TOTAL_BALANCE = "totalBalance";
    public static final String JSON_DEBT_AMOUNT = "debtAmount";
    public static final String JSON_CURRENCY_CODE = "currencyCode";
    public static final String JSON_CURRENCY = "currency";
    public static final String JSON_EXPIRY_DATE = "expiryDate";
    public static final String JSON_DEBIT_OPERATIONS_ALLOWED = "debitOperationsAllowed";
    public static final String JSON_RESTRICT_OPERATIONS_ABROAD = "restrictOperationsAbroad";
    public static final String JSON_IS_PRIMARY = "isPrimary";
    public static final String JSON_PAYMENT_SYSTEM = "paymentSystem";
    public static final String JSON_CARD_TYPE = "cardType";

    public static final String JSON_SESSION = "session";
    public static final String JSON_ACCOUNT = "account";


    // accounts
    public static final String JSON_CONTRACT_ID = "contractId";
    public static final String JSON_HOLD_AMOUNT = "holdAmount";
    public static final String JSON_BONUS_POINTS = "bonusPoints";


    // cards
    public static final String JSON_CARD_STATE_PENDING = "pending";
    public static final String JSON_CARD_STATE_EXPIRED = "expired";
    public static final String JSON_CARD_STATE_BLOCKED = "blocked";
    public static final String JSON_CARD_STATE_ACTIVE = "active";
    public static final String JSON_CARD_TYPE_CREDIT = "credit";
    public static final String JSON_CARD_TYPE_DEBIT = "debit";
    public static final String JSON_CARD_TYPE_VIRTUAL = "virtual";


    public static final String JSON_PYATEROCHKA = "pyaterochka";
    public static final String JSON_PYATEROCKA_LOGIN_PAGE = "pyaterockaLoginPage";
    public static final String JSON_PYATEROCKA_LANDING_PAGE = "pyaterockaLandingPage";
    public static final String JSON_ORDER_DEBIT_URL = "orderDebitUrl";
    public static final String JSON_REQUEST_CALL_URL = "requestCallUrl";
    public static final String JSON_PAYMENT_TERMS_URL = "paymentTermsUrl";

    // contracts
    public static final String JSON_ID = "id";
    public static final String JSON_CONTRACT_NUMBER = "contractNumber";
    public static final String JSON_TYPE = "type";
    public static final String JSON_PRODUCT_ID = "productId";
    public static final String JSON_PRODUCT_TYPE = "productType";
    public static final String JSON_PRODUCT_URL = "productUrl";
    public static final String JSON_INCOMING_DUE_AMOUNT = "incomingDueAmount";
    public static final String JSON_LIMIT_AMOUNT = "limitAmount";
    public static final String JSON_CREDIT_AMOUNT = "creditAmount";
    public static final String JSON_ORIGINAL_DEBT_AMOUNT = "originalDebtAmount";
    public static final String JSON_PAYED_AMOUNT = "payedAmount";
    public static final String JSON_DEBT_DUE_AMOUNT = "debtDueAmount";
    public static final String JSON_INTEREST_DUE_AMOUNT = "interestDueAmount";

    // loan contracts
    public static final String JSON_FEES_DUE_AMOUNTS = "feesDueAmounts";
    public static final String JSON_FEES_OVERDUE_AMOUNTS = "feesOverdueAmounts";

    // card contracts
    public static final String JSON_GRACE_DATE = "graceDate";
    public static final String JSON_GRACE_AMOUNT = "graceAmount";
    public static final String JSON_GRACE_AMOUNT_REST = "graceAmountRest";
    public static final String JSON_STATEMENT_DATE = "statementDate";
    public static final String JSON_PAYMENT_TERMS = "paymentTerms";
    public static final String JSON_PAYMENT_DUE_EVENT_ID = "paymentDueEventId";

    // deposit contracts
    public static final String JSON_PENDING_DATE = "pendingDate";
    public static final String JSON_PENDING_AMOUNT = "pendingAmount";
    public static final String JSON_PENDING_AMOUNT_REST = "pendingAmountRest";
    public static final String JSON_DEPOSIT_TERM = "depositTerm";
    public static final String JSON_DEPOSIT_INFO = "depositInfo";
    public static final String JSON_PERIOD = "period";
    public static final String JSON_NEXT_DATE = "nextdate";
    public static final String JSON_REQUISITES = "requisites";
    public static final String JSON_TRANSFER_AVAILABLE = "transferAvailable";
    public static final String JSON_WITHDRAWAL_AVAILABLE = "withdrawalAvailable";
    public static final String JSON_MIN_TRANSFER_AMOUNT = "minTransferAmount";
    public static final String JSON_MAX_TRANSFER_AMOUNT = "maxTransferAmount";


    public static final String JSON_IN_AMOUNT = "inAmount";
    public static final String JSON_OUT_AMOUNT = "outAmount";
    public static final String JSON_PLANNING_INTEREST_AMOUNT = "planningInterestAmount";
    public static final String JSON_INTEREST_RATES = "interestRates";
    public static final String JSON_EARLY_INTEREST_RATES = "earlyInterestRate";
    public static final String JSON_MIN_DEPOSIT_AMOUNT = "minDepositAmount";
    public static final String JSON_INTEREST_PAY_INFO = "interestPayInfo";
    public static final String JSON_INCOME_CLOSING_DATE = "incomeClosingDate";
    public static final String JSON_INTEREST_AMOUNT = "interestAmount";
    public static final String JSON_ORIGINAL_AMOUNT = "originalAmount";
    public static final String JSON_INTEREST_RETURN_AMOUNT = "interestReturnAmount";

    // deposit interest rates
    public static final String JSON_RATE = "rate";
    public static final String JSON_START_AMOUNT = "startAmount";
    public static final String JSON_END_AMOUNT = "endAmount";
    public static final String JSON_BEAR_AMOUNT = "bearAmount";

    // deposit interest types
    public static final String JSON_INTEREST_TYPE_NONE = "none";
    public static final String JSON_INTEREST_TYPE_CAPITALIZATION = "capitalization";
    public static final String JSON_INTEREST_TYPE_CONTRACT = "contract";
    public static final String JSON_INTEREST_TYPE_ACCOUNT = "account";
    // deposit interest payment types
    public static final String JSON_INTEREST_PAYMENT_TYPE_MONTHLY = "monthly";
    public static final String JSON_INTEREST_PAYMENT_TYPE_QUARTERLY = "quarterly";
    public static final String JSON_INTEREST_PAYMENT_TYPE_YEARLY = "yearly";

    // contract types
    public static final String JSON_CONTRACT_TYPE_CARD = "card";
    public static final String JSON_CONTRACT_TYPE_DEPOSIT = "deposit";
    public static final String JSON_CONTRACT_TYPE_GOAL = "goal";
    public static final String JSON_CONTRACT_TYPE_LOAN = "loan";
    public static final String JSON_CONTRACT_TYPE_CURRENT = "current";
    public static final String JSON_CONTRACT_TYPE_WALLET = "wallet";
    // contract states
    public static final String JSON_STATE_OPENED = "opened";
    public static final String JSON_STATE_CLOSED = "closed";
    public static final String JSON_STATE_PENDING = "pending";
    public static final String JSON_STATE_CANCELED = "canceled";
    public static final String JSON_STATE_PRECLOSED = "preclosed";


    // super rate
    public static final String JSON_SUPER_RATE = "superRate";
    public static final String JSON_STATE_DESCRIPTION = "stateDescription";
    public static final String JSON_NEW_RATE = "newRate";
    public static final String JSON_PERIOD_COUNT = "periodCount";
    public static final String JSON_PAY_COUNT = "payCount";
    public static final String JSON_RETURN_AMOUNT = "returnAmount";
    public static final String JSON_HAD_DELAYED_PAYMENTS = "hadDelayedPayments";
    public static final String JSON_PAYMENTS_STATE = "paymentsState";
    public static final String JSON_IS_REPAYED = "isRepayed";
    public static final String JSON_TERMS = "terms";

    public static final String JSON_TERM_STATE_FAIL = "fail";
    public static final String JSON_TERM_STATE_COMPLETED = "completed";
    public static final String JSON_TERM_STATE_PENDING = "pending";

    // requisites (TopUpMethod)
    public static final String JSON_TOP_UP_METHODS = "topUpMethods";
    public static final String JSON_INSTRUCTIONS = "instructions";
    public static final String JSON_DETAILS = "details";
    public static final String JSON_GUIDANCE = "guidance";
    public static final String JSON_NOTES = "notes";
    // method types
    public static final String JSON_THIRD_PARTY_BANKS = "thirdpartybanks";
    public static final String JSON_TERMINALS = "terminals";
    // detail types
    public static final String JSON_ADDRESSES = "addresses";
    public static final String JSON_BARCODE = "barcode";

    // barcodes
    public static final String JSON_PURPOSE_TOPUP = "topup";
    public static final String JSON_PURPOSE_WITHDRAW_ATM = "withdraw_atm";

    public static final String JSON_URL = "url";
    public static final String JSON_WIDTH = "width";
    public static final String JSON_HEIGHT = "height";
    public static final String JSON_PROMPT = "prompt";
    public static final String JSON_TTL = "ttl";


    // insurance
    public static final String JSON_INSURANCE_INFO = "insuranceInfo";
    public static final String JSON_PROGRAM_ID = "programId";
    public static final String JSON_PROGRAM_NAME = "programName";
    public static final String JSON_COVERAGE = "coverage";
    public static final String JSON_CONTACT_PHONE = "contactPhone";
    public static final String JSON_FEE_AMOUNT = "feeAmount";
    public static final String JSON_PROGRAM_URL = "programUrl";
    public static final String JSON_SERVICE_TYPE = "serviceType";
    public static final String JSON_INSURED_ACCIDENTS = "insuredAccidents";


    // payment schedule
    public static final String JSON_PAYMENTS_SCHEDULE = "paymentsSchedule";
    public static final String JSON_START_DATE = "startDate";
    public static final String JSON_END_DATE = "endDate";
    public static final String JSON_PAYMENTS = "payments";
    public static final String JSON_TERM = "term";
    public static final String JSON_DEBT_PAYMENTS_AMOUNT = "debtPaymentsAmount";
    public static final String JSON_DUE_AMOUNT = "dueAmount";
    public static final String JSON_DEBT_PAYED_AMOUNT = "debtPayedAmount";
    public static final String JSON_INTEREST_PAYED_AMOUNT = "interestPayedAmount";
    public static final String JSON_FEES_PAYED_AMOUNTS = "feesPayedAmounts";
    public static final String JSON_ADVANCE_AMOUNT = "advanceAmount";
    public static final String JSON_REST_AMOUNT = "restAmount";
    public static final String JSON_PAYED_REST_AMOUNT = "payedRestAmount";
    // payment states
    public static final String JSON_PAYMENT_STATE_DUE = "due";
    public static final String JSON_PAYMENT_STATE_PAID = "paid";
    public static final String JSON_PAYMENT_STATE_ONCOMING = "oncoming";
    public static final String JSON_PAYMENT_STATE_OVERDUE = "overdue";
    public static final String JSON_PAYMENT_STATE_MISSED = "missed";
    public static final String JSON_PAYMENT_STATE_EXCLUDED = "excluded";


    // event list
    public static final String JSON_TEMP_SID = "sessionId";
    public static final String JSON_SID = "sid";
    public static final String JSON_EVENTS = "events";
    public static final String JSON_PAGE = "page";
    public static final String JSON_COUNT = "count";
    public static final String JSON_FUTURE_COUNT = "futureCount";
    public static final String JSON_DIRECTION = "direction";
    public static final String JSON_CATEGORY_ID = "categoryId";
    public static final String JSON_DEFAULT_CATEGORY_ID = "defaultCategoryId";
    public static final String JSON_CATEGORY = "category";
    public static final String JSON_MONTH = "month";
    public static final String JSON_SUMMARY = "summary";
    public static final String JSON_TOTAL_DEBIT_AMOUNT = "totalDebitAmount";
    public static final String JSON_TOTAL_CREDIT_AMOUNT = "totalCreditAmount";
    public static final String JSON_SOURCE_EVENT_ID = "sourceEventId";
    public static final String JSON_CAN_REPEAT = "canRepeat";

    public static final String JSON_TIMESTAMP = "timestamp";
    public static final String JSON_IMPORTANT = "important";
    public static final String JSON_SERVICE = "service";
    public static final String JSON_CAPTION = "caption";
    public static final String JSON_TITLE = "title";
    public static final String JSON_CONTRACT = "contract";
    public static final String JSON_CREDIT_CONTRACT = "creditContract";
    public static final String JSON_ACCOUNTING_DATE = "accountingDate";
    public static final String JSON_CARD = "card";
    public static final String JSON_OPERATION_AMOUNT = "operationAmount";
    public static final String JSON_SCHEDULED_PAYMENT_STATE = "scheduledPaymentState";

    public static final String JSON_SCHEMA = "__schema";

    public static final String JSON_RUBLE_PLACEHOLDER = "##RUB";

    // metadata
    // types
    public static final String JSON_DATA_TYPE_STRING = "string";
    public static final String JSON_DATA_TYPE_HTML = "html";
    public static final String JSON_DATA_TYPE_URL = "url";
    public static final String JSON_DATA_TYPE_BOOLEAN = "boolean";
    public static final String JSON_DATA_TYPE_INTEGER = "integer";
    public static final String JSON_DATA_TYPE_DECIMAL = "decimal";
    public static final String JSON_DATA_TYPE_MONEY = "money";
    public static final String JSON_DATA_TYPE_DATE = "date";
    public static final String JSON_DATA_TYPE_DATETIME = "dateTime";
    public static final String JSON_DATA_TYPE_OBJECT = "object";
    public static final String JSON_DATA_TYPE_CONTRACT = "contract";
    public static final String JSON_DATA_TYPE_PAYMENT_TOOL = "paymentTool";
    public static final String JSON_DATA_TYPE_PRODUCT = "product";
    public static final String JSON_DATA_TYPE_POI = "poi";
    public static final String JSON_DATA_TYPE_MENU_ITEM = "menuItem";
    public static final String JSON_DATA_TYPE_CONFIRMATION = "confirmation";
    public static final String JSON_DATA_TYPE_BARCODE = "barcode";
    // input types
    public static final String JSON_INPUT_TYPE_TEXT = "text";
    public static final String JSON_INPUT_TYPE_CALENDAR = "calendar";
    public static final String JSON_INPUT_TYPE_MAP = "map";
    public static final String JSON_INPUT_TYPE_CHECKBOX = "checkbox";
    public static final String JSON_INPUT_TYPE_COMBOBOX = "combobox";
    public static final String JSON_INPUT_TYPE_CONFIRMATION = "confirmation";
    public static final String JSON_INPUT_TYPE_CARD_SCANNER = "cardScanner";
    public static final String JSON_INPUT_TYPE_STATUS = "status";
    public static final String JSON_INPUT_TYPE_SPINNER = "spinner";
    public static final String JSON_INPUT_TYPE_PAYMENT_TOOLS = "paymentTools";
    public static final String JSON_INPUT_TYPE_AMOUNT_EDITOR = "amountEditor";
    public static final String JSON_INPUT_TYPE_MONEY_EDITOR = "moneyEditor";
    public static final String JSON_INPUT_TYPE_CAROUSEL = "carousel";
    public static final String JSON_INPUT_TYPE_ADDRESS_BOOK = "addressBook";
    public static final String JSON_INPUT_TYPE_PRODUCT_SELECTOR = "productSelector";
    public static final String JSON_INPUT_TYPE_MENU_SELECTOR = "menuSelector";
    public static final String JSON_INPUT_TYPE_GEO_SELECTOR = "geoSelector";
    public static final String JSON_INPUT_TYPE_GROUP = "group";
    public static final String JSON_INPUT_TYPE_STEP = "step";
    public static final String JSON_INPUT_TYPE_LOAN_CALCULATOR = "loanCalculator";
    public static final String JSON_INPUT_TYPE_APPLICATION_EDITOR = "applicationEditor";
    public static final String JSON_INPUT_TYPE_APPLICATION_INFO = "applicationInfo";
    public static final String JSON_INPUT_TYPE_FILE = "file";
    public static final String JSON_DATA_TYPE_PHOTO = "photo";
    public static final String JSON_DATA_TYPE_OCR = "ocr";
    // hints
    public static final String JSON_HINT_COMPARE = "compare";
    public static final String JSON_HINT_SUPERRATE = "superrate";
    public static final String JSON_HINT_GOOD = "good";
    public static final String JSON_HINT_BAD = "bad";
    public static final String JSON_HINT_INFO = "info";
    public static final String JSON_HINT_PROGRESS = "progress";
    public static final String JSON_HINT_SLIDER = "slider";
    public static final String JSON_HINT_PERCENTS = "percents";

    public static final String JSON_HINT_FIRST_DATE = "firstDate";

    public static final String JSON_HINT_PASSPORT = "passport";
    public static final String JSON_HINT_PASSPORT_SERIES = "passport_series";
    public static final String JSON_HINT_PASSPORT_NUMBER = "passport_number";
    public static final String JSON_HINT_PASSPORT_AUTHORITY = "passport_issuer";
    public static final String JSON_HINT_PASSPORT_ISSUE_DATE = "passport_issued_date";
    public static final String JSON_HINT_PASSPORT_AUTHORITY_CODE = "passport_issuer_code";
    public static final String JSON_HINT_PASSPORT_BIRTHPLACE = "passport_birth_place";
    public static final String JSON_HINT_PASSPORT_BIRTHDATE = "passport_birth_date";
    public static final String JSON_HINT_PASSPORT_PATRONYMIC = "passport_patronymic";
    public static final String JSON_HINT_PASSPORT_NAME = "passport_name";
    public static final String JSON_HINT_PASSPORT_SURNAME = "passport_surname";
    public static final String JSON_HINT_PASSPORT_GENDER = "passport_gender";
    public static final String JSON_HINT_ADD_DOC_SERIES = "foreign_passport_series";
    public static final String JSON_HINT_ADD_DOC_NUMBER = "foreign_passport_number";
    public static final String JSON_HINT_ADD_DOC_ISSUE_DATE = "foreign_passport_issued_date";

    public static final String JSON_HINT_STS_SERIES = "sts_series";
    public static final String JSON_HINT_STS_NUMBER = "sts_number";
    public static final String JSON_HINT_STS_GOSNUMBER = "sts_gosnumber";
    public static final String JSON_HINT_SNILS_NUMBER = "snils_number";


    public static final String JSON_HINT_SECOND_DOC_NUMBER = "card_number_last6";//"add_doc_number";
    public static final String JSON_HINT_SECOND_DOC_ISSUE_DATE = "card_expire_date";//"add_doc_issued_date";

    public static final String JSON_HINT_ADD_DRVLIC_SERIES = "driver_license_series";
    public static final String JSON_HINT_ADD_DRVLIC_NUMBER = "driver_license_number";
    public static final String JSON_HINT_ADD_DRVLIC_ISSUE_DATE = "driver_license_issued_date";

    // status
    public static final String JSON_STATUS_NEW = "new";
    public static final String JSON_STATUS_PROCESSING = "processing";
    public static final String JSON_STATUS_COMPLETED = "completed";
    public static final String JSON_STATUS_REJECTED = "rejected";

    // fields
    public static final String JSON_SORT_ORDER = "sortOrder";
    public static final String JSON_HIDDEN_RELATION_REF = "hiddenRelationRef";
    public static final String JSON_HIDDEN_REGEXP = "hiddenRegexp";
    public static final String JSON_READ_ONLY = "readOnly";
    public static final String JSON_READ_ONLY_RELATION_REF = "readOnlyRelationRef";
    public static final String JSON_READ_ONLY_REGEXP = "readOnlyRegexp";
    public static final String JSON_IS_REQUIRED = "isRequired";
    public static final String JSON_REFRESH_ON_CHANGE = "refreshOnChange";
    public static final String JSON_INPUT_TYPE = "inputType";
    public static final String JSON_INPUT_TYPES = "inputTypes";
    public static final String JSON_EDITORS = "editors";
    public static final String JSON_DEFAULT_VALUE = "defaultValue";
    public static final String JSON_DEFAULT = "default";
    public static final String JSON_MIN = "min";
    public static final String JSON_MAX = "max";
    public static final String JSON_AVAILABLE_VALUES = "availableValues";
    public static final String JSON_PRIORITY = "priority";
    public static final String JSON_HINTS = "hints";
    public static final String JSON_REGEXP = "regexp";
    public static final String JSON_OPERATION_TYPE = "operationType";
    public static final String JSON_TARIFF = "tariff";
    public static final String JSON_CONFIRMATION = "confirmation";
    public static final String JSON_CARD_NUMBER_PC = "cardNumber";

    public static final String JSON_UNKNOWN = "unknown";

    // event types
    public static final String JSON_EVENT_TYPE_CONTRACT_CHANGE_STATUS = "changeStatus";
    public static final String JSON_EVENT_TYPE_CONTRACT_SERVICE_HISTORY = "contractServiceHistory";
    public static final String JSON_EVENT_TYPE_SCHEDULED_PAYMENT = "scheduledPayment";
    public static final String JSON_EVENT_TYPE_PAYMENT = "payment";
    public static final String JSON_EVENT_TYPE_OPERATION = "operation";
    public static final String JSON_EVENT_TYPE_HOLD = "hold";
    public static final String JSON_EVENT_TYPE_REPAYMENT = "repayment";
    public static final String JSON_EVENT_TYPE_PROMO = "promo";
    public static final String JSON_EVENT_TYPE_FEES = "fees";
    public static final String JSON_SET_PROTECT_CODE = "setprotectcode";

    // event doc types
    public static final String JSON_AVAILABLE_DOCUMENTS = "availableDocuments";
    public static final String JSON_RECEIPT = "receipt";
    public static final String JSON_TRANSFER = "transfer";

    public static final String JSON_OPERATION_TYPE_CREDIT = "credit";
    public static final String JSON_OPERATION_TYPE_DEBIT = "debit";
    public static final String JSON_OPERATION_TYPE_DEBIT_CREDIT = "debitcredit";

    // direction
    public static final String JSON_DIRECTION_FUTURE = "future";
    public static final String JSON_DIRECTION_PAST = "past";

    // geolocation
    // deposit interest rates
    public static final String JSON_LAT = "lat";
    public static final String JSON_LNG = "lng";
    public static final String JSON_SOUTH_WEST = "southWest";
    public static final String JSON_NORD_EAST = "nordEast";
    public static final String JSON_COLOR = "color";
    public static final String JSON_LINE = "line";
    public static final String JSON_CITY = "city";
    public static final String JSON_REGION = "region";
    public static final String JSON_LOCATION = "location";
    public static final String JSON_ADDRESS = "address";
    public static final String JSON_SUBWAY_STATION = "subwayStation";
    public static final String JSON_ADDITIONAL_INFO = "additionalInfo";
    public static final String JSON_IMPORTANT_INFO = "importantInfo";
    public static final String JSON_SCHEDULE = "schedule";
    public static final String JSON_RATING = "rating";
    public static final String JSON_CREATED_AT = "createdAt";
    public static final String JSON_MODIFIED_AT = "modifiedAt";
    public static final String JSON_DELETED = "deleted";
    public static final String JSON_AREA = "area";


    // geoObject
    public static final String JSON_FULL_NAME = "fullName";
    public static final String JSON_COUNTRY_NAME = "countryName";
    public static final String JSON_COUNTRY = "country";
    public static final String JSON_ADMINISTRATIVE_AREA = "administrativeArea";
    public static final String JSON_SUB_ADMINISTRATIVE_AREA = "subAdministrativeArea";
    public static final String JSON_LOCALITY_NAME = "localityName";
    public static final String JSON_LOCALITY = "locality";
    public static final String JSON_QUERY = "query";
    public static final String JSON_WORKING_HOURS = "workingHours";
    public static final String JSON_EXCEPT = "except";

    // POI types
    public static final String JSON_POI_TYPE_BUSINESS_PARTNER = "businessPartner";
    public static final String JSON_POI_TYPE_PARTNER = "partner";
    public static final String JSON_POI_TYPE_OFFICE = "office";
    public static final String JSON_POI_TYPE_STAND = "stand";
    public static final String JSON_POI_TYPE_ATM = "atm";
    public static final String JSON_POI_TYPE_TERMINAL = "terminal";

    // POI services
    public static final String JSON_A = "a";
    public static final String JSON_NA = "na";
    public static final String JSON_CASH_IN_RUB = "cashInRUB";
    public static final String JSON_CASH_OUT_USD = "cashOutUSD";
    public static final String JSON_CASH_OUT_RUB = "cashOutRUB";
    public static final String JSON_CASH_OUT_EUR = "cashOutEUR";


    // POI operations
    public static final String JSON_POI_OPERATION_GET = "Выдача наличных";
    public static final String JSON_POI_OPERATION_SET = "Прием наличных";

    // POI days
    public static final String JSON_MONDAY = "monday";
    public static final String JSON_TUESDAY = "tuesday";
    public static final String JSON_WEDNESDAY = "wednesday";
    public static final String JSON_THURSDAY = "thursday";
    public static final String JSON_FRIDAY = "friday";
    public static final String JSON_SATURDAY = "saturday";
    public static final String JSON_SUNDAY = "sunday";

    // Yandex geolocation
    public static final String JSON_YANDEX_RESPONSE = "response";
    public static final String JSON_YANDEX_GEO_OBJECT_COLLECTION = "GeoObjectCollection";
    public static final String JSON_YANDEX_FEATURE_MEMBER = "featureMember";
    public static final String JSON_YANDEX_GEO_META_DATA_PROPERTY = "metaDataProperty";
    public static final String JSON_YANDEX_GEO_OBJECT = "GeoObject";
    public static final String JSON_YANDEX_GEO_DESCRIPTION = "description";
    public static final String JSON_YANDEX_GEO_NAME = "name";
    public static final String JSON_YANDEX_POINT = "Point";
    public static final String JSON_YANDEX_POSITION = "pos";

    // Templates
    public static final String JSON_TEMPLATE_ID = "templateId";
    public static final String JSON_OPERATION_ID = "operationId";
    public static final String JSON_CREATED_DATE = "createdDate";
    public static final String JSON_LAST_USED_DATE = "lastUsedDate";
    public static final String JSON_LAST_PAYMENT_AMOUNT = "lastPaymentAmount";
    public static final String JSON_AMOUUNT = "amount";
    public static final String JSON_USAGE_COUNT = "usageCount";
    public static final String JSON_IS_FAVORITE = "isFavorite";
    public static final String JSON_PARAMETERS = "parameters";
    public static final String JSON_PAYMENT_TOOL = "paymentTool";
    public static final String JSON_UPDATED_DATE = "updatedDate";
    public static final String JSON_DELETED_DATE = "deletedDate";
    public static final String JSON_ORDER_ID = "orderId";
    public static final String JSON_GROUP_IDS = "groupIds";
    public static final String JSON_MENU_PARENT_ID = "menuParentId";
    public static final String JSON_MAX_LENGTH = "maxLength";

    // menu
    public static final String JSON_TOTAL_COUNT = "totalCount";
    public static final String JSON_TAGS = "tags";
    public static final String JSON_SUPPRESS_FEATURES = "suppressFeatures";
    public static final String JSON_IMAGES_LOCATION = "imagesLocation";
    public static final String JSON_IMAGE_NAME = "imageName";
    // types
    public static final String JSON_MENU_TYPE_ITEM = "item";
    public static final String JSON_MENU_TYPE_FOLDER = "folder";
    // feature
    public static final String JSON_FEATURE_SEARCH = "search";
    public static final String JSON_FEATURE_IMAGES = "images";
    // location
    public static final String JSON_LOCATION_WIDE_AREA = "wideArea";
    public static final String JSON_LOCATION_HOME = "home";

    // services
    public static final String JSON_SERVICES = "services";
    public static final String JSON_CONTRACT_SERVICES = "contractServiceStates";
    public static final String JSON_SERVICE_ID = "serviceId";
    public static final String JSON_HIDDEN = "hidden";
    public static final String JSON_BLOCKED = "blocked";
    public static final String JSON_IS_ACTIVE = "isActive";
    public static final String JSON_ACTIVE = "active";
    public static final String JSON_DESCRIPTION = "description";
    public static final String JSON_CHANNEL_TYPE = "channelType";
    public static final String JSON_IS_AVAILABLE = "isAvailable";
    public static final String JSON_AVAILABILITY_DATE = "availabilityDate";
    public static final String JSON_ACTIVATION_DATE = "activationDate";
    public static final String JSON_DEACTIVATION_DATE = "deactivationDate";
    public static final String JSON_THIRD_PARTY_CARD = "thirdPartyCard";
    public static final String JSON_NEXT_EXECUTION_DATE = "nextExecutionDate";

    // service types

    /**
     * Autorepayment - automatic loan/credit card debt repayment from attached card
     */
    public static final String JSON_SERVICE_TYPE_AUTOREPAYMENT = "Repayment";
    public static final String JSON_SERVICE_TYPE_CHANGE_PAYMENT_DATE = "ChangePayDate";

    /**
     * Paid notifications
     */
    public static final String JSON_SERVICE_TYPE_INFO = "Info";
    public static final String JSON_SERVICE_TYPE_SKIP_PAYMENT = "SkipPay";
    public static final String JSON_SERVICE_TYPE_INSURANCE = "Insur";
    // TODO clarify

    public static final String JSON_CARD_UID = "cardUid";
    /**
     * Automatical adding of funds
     */
    public static final String JSON_SERVICE_TYPE_AUTOADDING = "Adding";
    // TODO clarify

    /**
     * Automatic payments
     */
    public static final String JSON_SERVICE_TYPE_AUTOPAYMENT = "Payment";
    public static final String JSON_SERVICE_TYPE_REDUCE_PAYMENT = "ReducePay";

    /**
     * Partial preterm repayment with reduces subsequent payments
     */
    public static final String JSON_SERVICE_TYPE_EASY_PAYMENT = "EasyPay";

    public static final String JSON_SERVICE_TYPE_FULL_PAYMENT = "FullPayment";
    public static final String JSON_SERVICE_TYPE_REISSUE = "Reissue";
    public static final String JSON_SERVICE_TYPE_CLOSE_CARD = "closeCard";
    public static final String JSON_SERVICE_TYPE_PROLONGATION = "prolongation";


    // operations
    public static final String JSON_ERROR = "__error";
    public static final String JSON_ERRORS = "errors";
    public static final String JSON_FATAL = "fatal";
    public static final String JSON_UPDATE_AFTER = "updateAfter";
    public static final String JSON_FIELD = "field";
    public static final String JSON_STATUS = "status";
    public static final String JSON_FEE = "fee";
    public static final String JSON_TOTAL = "total";
    public static final String JSON_IS_TEMPLATED = "__isTemplated";
    public static final String JSON_SAVE_TEMPLATE = "__saveTemplate";
    public static final String JSON_TEMPLATE = "__template";
    public static final String JSON_TEMPLATE_SIMPLE = "template";
    public static final String JSON_REGISTER_CARD = "registerCard";
    public static final String JSON_OPERATION_MAX_AMOUNT = "operationMaxAmount";
    public static final String JSON_OPERATION_MIN_AMOUNT = "operationMinAmount";
    public static final String JSON_PREV_OPERATION_ID = "prevOperationId";
    public static final String JSON_CONTINUATION = "continuation";

    // limits
    public static final String JSON_CURRENT_NAME = "currentName";
    public static final String JSON_INACTIVE_NAME = "inactiveName";
    public static final String JSON_CATEGORY_NAME = "categoryName";
    public static final String JSON_START_TIME = "startTime";
    public static final String JSON_END_TIME = "endTime";
    public static final String JSON_CURRENT_COUNT = "currentCount";
    public static final String JSON_MAX_COUNT = "maxCount";
    public static final String JSON_CURRENT_AMOUNT = "currentAmount";
    public static final String JSON_MAX_AMOUNT = "maxAmount";
    public static final String JSON_RESET_HISTORY = "resetHistory";
    public static final String JSON_TIME = "time";
    public static final String JSON_LIMITS = "limits";

    // period types
    public static final String JSON_PERIOD_NONE = "none";
    public static final String JSON_PERIOD_ONETIME = "onetime";
    public static final String JSON_PERIOD_DAY = "day";
    public static final String JSON_PERIOD_WEEK = "week";
    public static final String JSON_PERIOD_MONTH = "month";
    public static final String JSON_PERIOD_QUARTER = "quarter";
    public static final String JSON_PERIOD_YEAR = "year";


    // notifications
    // registration
    public static final String JSON_HWID = "hwid";
    public static final String JSON_APPLICATION = "application";
    public static final String JSON_APPLICATION_VERSION = "applicationVersion";
    public static final String JSON_ENVIRONMENT = "environment";
    public static final String JSON_HARDWARE_MODEL = "hwModel";
    public static final String JSON_PUSH_TOKEN = "pushToken";
    public static final String JSON_LANGUAGE = "language";
    public static final String JSON_OS_VERSION = "osVersion";
    public static final String JSON_PLATFORM = "platform";
    public static final String JSON_PLATFORM_VERSION = "platformVersion";
    public static final String JSON_TIMEZONE = "timezone";
    public static final String JSON_TIMEZONE_UPCASE = "timeZone";
    public static final String JSON_BIRTHDATE = "birthdate";
    public static final String JSON_PROTECT_CODE_CONFIRMATION = "protectcodeconfirmation";
    public static final String JSON_PROTECT_CODE = "protectcode";

    public static final String JSON_TEMPLATES = "templates";
    public static final String JSON_TRANSFERS = "transfers";

    // messages
    public static final String JSON_MESSAGE = "message";
    //    public static final String JSON_MESSAGE_ID = "messageId";
    public static final String JSON_FROM = "from";
    public static final String JSON_TO = "to";
    public static final String JSON_PARTIAL = "partial";
    public static final String JSON_TEXT = "text";
    public static final String JSON_HISTORY_EVENT_ID = "historyEventId";

    // message types
    public static final String JSON_MESSAGE_TYPE_DUE_PAYMENT_LOAN = "duePaymentLoan";
    public static final String JSON_MESSAGE_TYPE_DUE_PAYMENT_CARD = "duePaymentCard";
    public static final String JSON_MESSAGE_TYPE_OVERDUE_PAYMENT_LOAN = "overduePaymentLoan";
    public static final String JSON_MESSAGE_TYPE_OVERDUE_PAYMENT_CARD = "overduePaymentCard";

    // Promo
    public static final String JSON_PERSONAL_ID = "personalId";
    public static final String JSON_EXPIRES = "expires";
    public static final String JSON_START_AT = "startAt";
    public static final String JSON_VIEW_SEQUENCE = "viewSequence";
    public static final String JSON_PERSONAL = "personal";
    public static final String JSON_PUBLIC = "public";
    public static final String JSON_PRODUCT = "product";
    public static final String JSON_OTHER = "other";
    public static final String JSON_LEFT = "left";
    public static final String JSON_CENTER = "center";
    public static final String JSON_TEXT_ALIGN = "text-align";
    public static final String JSON_ICON_IMAGE = "iconImage";
    public static final String JSON_LINK = "link";
    public static final String JSON_BUTTON = "button";

    public static final String JSON_DASHBOARD_POPUP = "dashboard_popup";
    public static final String JSON_DASHBOARD_POPUP_CLOSABLE = "dashboard_popup_Closable";
    public static final String JSON_DASHBOARD_BANNER = "dashboard_banner";
    public static final String JSON_DASHBOARD_BANNER_CLOSABLE = "dashboard_banner_Closable";
    public static final String JSON_TIMELINE_BANNER = "timeline_banner";
    public static final String JSON_TIMELINE_BANNER_CLOSABLE = "timeline_banner_Closable";
    public static final String JSON_PAYMENTS_BLOCK = "operations_block";
    public static final String JSON_PAYMENTS_BLOCK_CLOSABLE = "operations_block_Closable";

    public static final String JSON_CLOSE = "close";
    public static final String JSON_OPEN = "open";
    public static final String JSON_CLICK = "click";
    public static final String JSON_SEND_REQUEST = "sendRequest";
    public static final String JSON_REJECTED = "rejected";
    public static final String JSON_ACCEPTED = "accepted";
    public static final String JSON_UNDEFINED = "undefined";
    public static final String JSON_HEADER = "header";
    public static final String JSON_OTP_RESULT = "otp-result";
    public static final String JSON_OTP_CODE = "otp-code";
    public static final String JSON_CHECK_DOC = "check-doc";
    public static final String JSON_UNCHECK_DOC = "uncheck-doc";


    // identity status
    public static final String JSON_NONE = "none";
    public static final String JSON_IN_PROGRESS = "inprogress";
    public static final String JSON_IDENTIFICATION_STATUS = "identificationStatus";
    public static final String JSON_FINALIZED = "finalized";

    public static final String JSON_PES = "pes";
    public static final String JSON_PERSONALCHECK = "personalcheck";
    public static final String JSON_MOBILE = "mobile";
    public static final String JSON_MIDDLENAME = "middlename";
    public static final String JSON_FIRSTNAME = "firstname";
    public static final String JSON_LASTNAME = "lastname";

    public static final String JSON_MAPPED_SERVICE_THIRD_PARTY_CARD = "thirdPartyCard";

    // card loyalty
    public static final String JSON_LOYALTY_TYPE_PYATEROCHKA = "ts5";
    public static final String JSON_LOYALTIES = "loyalties";
    public static final String JSON_LOYALTY_CODE = "loyaltyCode";
    public static final String JSON_CARD_ID = "cardId";

    // login
    public static final String JSON_EXT_PROTECTION_CODE = "extProtectCode";
    public static final String JSON_PROTECTION_CODE = "protectCode";
    public static final String JSON_LOGIN = "login";
    public static final String JSON_PASSWORD = "password";
    public static final String JSON_CHANNEL = "channel";
    public static final String JSON_SETUP_PROTECTION_CODE = "setProtectCode";

    //otp
    public static final String JSON_LOGIN_OR_EXT_PROTECTION_CODE = "loginOrExtProtectCode";
    public static final String JSON_LOGIN_OTP = "otp";

    public static final String JSON_CARD_STYLE_LIGHT = "light";
    public static final String JSON_CARD_STYLE_DARK = "dark";

    public static final String JSON_DISTANCE_TARGET = "distanceTarget";

    //contacts binding
    public static final String JSON_PARENT_PHONE = "parentPhone";
    public static final String JSON_RELATIVE_TYPE = "relativeType";
    public static final String JSON_CLIENT_TYPE = "clientType";
    public static final String JSON_BINDING_ID = "bindingid";
    public static final String JSON_CONF_CODE = "confcode";
}
