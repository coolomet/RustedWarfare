package com.codedisaster.steamworks;

public final class SteamResult {
    public static final SteamResult OK = new SteamResult("OK", 0, 1);
    public static final SteamResult Fail = new SteamResult("Fail", 1, 2);
    public static final SteamResult NoConnection = new SteamResult("NoConnection", 2, 3);
    public static final SteamResult InvalidPassword = new SteamResult("InvalidPassword", 3, 5);
    public static final SteamResult LoggedInElsewhere = new SteamResult("LoggedInElsewhere", 4, 6);
    public static final SteamResult InvalidProtocolVer = new SteamResult("InvalidProtocolVer", 5, 7);
    public static final SteamResult InvalidParam = new SteamResult("InvalidParam", 6, 8);
    public static final SteamResult FileNotFound = new SteamResult("FileNotFound", 7, 9);
    public static final SteamResult Busy = new SteamResult("Busy", 8, 10);
    public static final SteamResult InvalidState = new SteamResult("InvalidState", 9, 11);
    public static final SteamResult InvalidName = new SteamResult("InvalidName", 10, 12);
    public static final SteamResult InvalidEmail = new SteamResult("InvalidEmail", 11, 13);
    public static final SteamResult DuplicateName = new SteamResult("DuplicateName", 12, 14);
    public static final SteamResult AccessDenied = new SteamResult("AccessDenied", 13, 15);
    public static final SteamResult Timeout = new SteamResult("Timeout", 14, 16);
    public static final SteamResult Banned = new SteamResult("Banned", 15, 17);
    public static final SteamResult AccountNotFound = new SteamResult("AccountNotFound", 16, 18);
    public static final SteamResult InvalidSteamID = new SteamResult("InvalidSteamID", 17, 19);
    public static final SteamResult ServiceUnavailable = new SteamResult("ServiceUnavailable", 18, 20);
    public static final SteamResult NotLoggedOn = new SteamResult("NotLoggedOn", 19, 21);
    public static final SteamResult Pending = new SteamResult("Pending", 20, 22);
    public static final SteamResult EncryptionFailure = new SteamResult("EncryptionFailure", 21, 23);
    public static final SteamResult InsufficientPrivilege = new SteamResult("InsufficientPrivilege", 22, 24);
    public static final SteamResult LimitExceeded = new SteamResult("LimitExceeded", 23, 25);
    public static final SteamResult Revoked = new SteamResult("Revoked", 24, 26);
    public static final SteamResult Expired = new SteamResult("Expired", 25, 27);
    public static final SteamResult AlreadyRedeemed = new SteamResult("AlreadyRedeemed", 26, 28);
    public static final SteamResult DuplicateRequest = new SteamResult("DuplicateRequest", 27, 29);
    public static final SteamResult AlreadyOwned = new SteamResult("AlreadyOwned", 28, 30);
    public static final SteamResult IPNotFound = new SteamResult("IPNotFound", 29, 31);
    public static final SteamResult PersistFailed = new SteamResult("PersistFailed", 30, 32);
    public static final SteamResult LockingFailed = new SteamResult("LockingFailed", 31, 33);
    public static final SteamResult LogonSessionReplaced = new SteamResult("LogonSessionReplaced", 32, 34);
    public static final SteamResult ConnectFailed = new SteamResult("ConnectFailed", 33, 35);
    public static final SteamResult HandshakeFailed = new SteamResult("HandshakeFailed", 34, 36);
    public static final SteamResult IOFailure = new SteamResult("IOFailure", 35, 37);
    public static final SteamResult RemoteDisconnect = new SteamResult("RemoteDisconnect", 36, 38);
    public static final SteamResult ShoppingCartNotFound = new SteamResult("ShoppingCartNotFound", 37, 39);
    public static final SteamResult Blocked = new SteamResult("Blocked", 38, 40);
    public static final SteamResult Ignored = new SteamResult("Ignored", 39, 41);
    public static final SteamResult NoMatch = new SteamResult("NoMatch", 40, 42);
    public static final SteamResult AccountDisabled = new SteamResult("AccountDisabled", 41, 43);
    public static final SteamResult ServiceReadOnly = new SteamResult("ServiceReadOnly", 42, 44);
    public static final SteamResult AccountNotFeatured = new SteamResult("AccountNotFeatured", 43, 45);
    public static final SteamResult AdministratorOK = new SteamResult("AdministratorOK", 44, 46);
    public static final SteamResult ContentVersion = new SteamResult("ContentVersion", 45, 47);
    public static final SteamResult TryAnotherCM = new SteamResult("TryAnotherCM", 46, 48);
    public static final SteamResult PasswordRequiredToKickSession = new SteamResult("PasswordRequiredToKickSession", 47, 49);
    public static final SteamResult AlreadyLoggedInElsewhere = new SteamResult("AlreadyLoggedInElsewhere", 48, 50);
    public static final SteamResult Suspended = new SteamResult("Suspended", 49, 51);
    public static final SteamResult Cancelled = new SteamResult("Cancelled", 50, 52);
    public static final SteamResult DataCorruption = new SteamResult("DataCorruption", 51, 53);
    public static final SteamResult DiskFull = new SteamResult("DiskFull", 52, 54);
    public static final SteamResult RemoteCallFailed = new SteamResult("RemoteCallFailed", 53, 55);
    public static final SteamResult PasswordUnset = new SteamResult("PasswordUnset", 54, 56);
    public static final SteamResult ExternalAccountUnlinked = new SteamResult("ExternalAccountUnlinked", 55, 57);
    public static final SteamResult PSNTicketInvalid = new SteamResult("PSNTicketInvalid", 56, 58);
    public static final SteamResult ExternalAccountAlreadyLinked = new SteamResult("ExternalAccountAlreadyLinked", 57, 59);
    public static final SteamResult RemoteFileConflict = new SteamResult("RemoteFileConflict", 58, 60);
    public static final SteamResult IllegalPassword = new SteamResult("IllegalPassword", 59, 61);
    public static final SteamResult SameAsPreviousValue = new SteamResult("SameAsPreviousValue", 60, 62);
    public static final SteamResult AccountLogonDenied = new SteamResult("AccountLogonDenied", 61, 63);
    public static final SteamResult CannotUseOldPassword = new SteamResult("CannotUseOldPassword", 62, 64);
    public static final SteamResult InvalidLoginAuthCode = new SteamResult("InvalidLoginAuthCode", 63, 65);
    public static final SteamResult AccountLogonDeniedNoMail = new SteamResult("AccountLogonDeniedNoMail", 64, 66);
    public static final SteamResult HardwareNotCapableOfIPT = new SteamResult("HardwareNotCapableOfIPT", 65, 67);
    public static final SteamResult IPTInitError = new SteamResult("IPTInitError", 66, 68);
    public static final SteamResult ParentalControlRestricted = new SteamResult("ParentalControlRestricted", 67, 69);
    public static final SteamResult FacebookQueryError = new SteamResult("FacebookQueryError", 68, 70);
    public static final SteamResult ExpiredLoginAuthCode = new SteamResult("ExpiredLoginAuthCode", 69, 71);
    public static final SteamResult IPLoginRestrictionFailed = new SteamResult("IPLoginRestrictionFailed", 70, 72);
    public static final SteamResult AccountLockedDown = new SteamResult("AccountLockedDown", 71, 73);
    public static final SteamResult AccountLogonDeniedVerifiedEmailRequired = new SteamResult("AccountLogonDeniedVerifiedEmailRequired", 72, 74);
    public static final SteamResult NoMatchingURL = new SteamResult("NoMatchingURL", 73, 75);
    public static final SteamResult BadResponse = new SteamResult("BadResponse", 74, 76);
    public static final SteamResult RequirePasswordReEntry = new SteamResult("RequirePasswordReEntry", 75, 77);
    public static final SteamResult ValueOutOfRange = new SteamResult("ValueOutOfRange", 76, 78);
    public static final SteamResult UnexpectedError = new SteamResult("UnexpectedError", 77, 79);
    public static final SteamResult Disabled = new SteamResult("Disabled", 78, 80);
    public static final SteamResult InvalidCEGSubmission = new SteamResult("InvalidCEGSubmission", 79, 81);
    public static final SteamResult RestrictedDevice = new SteamResult("RestrictedDevice", 80, 82);
    public static final SteamResult RegionLocked = new SteamResult("RegionLocked", 81, 83);
    public static final SteamResult RateLimitExceeded = new SteamResult("RateLimitExceeded", 82, 84);
    public static final SteamResult AccountLoginDeniedNeedTwoFactor = new SteamResult("AccountLoginDeniedNeedTwoFactor", 83, 85);
    public static final SteamResult ItemDeleted = new SteamResult("ItemDeleted", 84, 86);
    public static final SteamResult AccountLoginDeniedThrottle = new SteamResult("AccountLoginDeniedThrottle", 85, 87);
    public static final SteamResult TwoFactorCodeMismatch = new SteamResult("TwoFactorCodeMismatch", 86, 88);
    public static final SteamResult TwoFactorActivationCodeMismatch = new SteamResult("TwoFactorActivationCodeMismatch", 87, 89);
    public static final SteamResult AccountAssociatedToMultiplePartners = new SteamResult("AccountAssociatedToMultiplePartners", 88, 90);
    public static final SteamResult NotModified = new SteamResult("NotModified", 89, 91);
    public static final SteamResult NoMobileDevice = new SteamResult("NoMobileDevice", 90, 92);
    public static final SteamResult TimeNotSynced = new SteamResult("TimeNotSynced", 91, 93);
    public static final SteamResult SmsCodeFailed = new SteamResult("SmsCodeFailed", 92, 94);
    public static final SteamResult AccountLimitExceeded = new SteamResult("AccountLimitExceeded", 93, 95);
    public static final SteamResult AccountActivityLimitExceeded = new SteamResult("AccountActivityLimitExceeded", 94, 96);
    public static final SteamResult PhoneActivityLimitExceeded = new SteamResult("PhoneActivityLimitExceeded", 95, 97);
    public static final SteamResult RefundToWallet = new SteamResult("RefundToWallet", 96, 98);
    public static final SteamResult EmailSendFailure = new SteamResult("EmailSendFailure", 97, 99);
    public static final SteamResult NotSettled = new SteamResult("NotSettled", 98, 100);
    public static final SteamResult NeedCaptcha = new SteamResult("NeedCaptcha", 99, 101);
    public static final SteamResult GSLTDenied = new SteamResult("GSLTDenied", 100, 102);
    public static final SteamResult GSOwnerDenied = new SteamResult("GSOwnerDenied", 101, 103);
    public static final SteamResult InvalidItemType = new SteamResult("InvalidItemType", 102, 104);
    public static final SteamResult IPBanned = new SteamResult("IPBanned", 103, 105);
    public static final SteamResult GLSTExpired = new SteamResult("GLSTExpired", 104, 106);
    public static final SteamResult UnknownErrorCode_NotImplementedByAPI = new SteamResult("UnknownErrorCode_NotImplementedByAPI", 105, 0);
    private final int code;
    private static final SteamResult[] valuesLookupTable;
    // $FF: synthetic field
    private static final SteamResult[] $VALUES = new SteamResult[]{OK, Fail, NoConnection, InvalidPassword, LoggedInElsewhere, InvalidProtocolVer, InvalidParam, FileNotFound, Busy, InvalidState, InvalidName, InvalidEmail, DuplicateName, AccessDenied, Timeout, Banned, AccountNotFound, InvalidSteamID, ServiceUnavailable, NotLoggedOn, Pending, EncryptionFailure, InsufficientPrivilege, LimitExceeded, Revoked, Expired, AlreadyRedeemed, DuplicateRequest, AlreadyOwned, IPNotFound, PersistFailed, LockingFailed, LogonSessionReplaced, ConnectFailed, HandshakeFailed, IOFailure, RemoteDisconnect, ShoppingCartNotFound, Blocked, Ignored, NoMatch, AccountDisabled, ServiceReadOnly, AccountNotFeatured, AdministratorOK, ContentVersion, TryAnotherCM, PasswordRequiredToKickSession, AlreadyLoggedInElsewhere, Suspended, Cancelled, DataCorruption, DiskFull, RemoteCallFailed, PasswordUnset, ExternalAccountUnlinked, PSNTicketInvalid, ExternalAccountAlreadyLinked, RemoteFileConflict, IllegalPassword, SameAsPreviousValue, AccountLogonDenied, CannotUseOldPassword, InvalidLoginAuthCode, AccountLogonDeniedNoMail, HardwareNotCapableOfIPT, IPTInitError, ParentalControlRestricted, FacebookQueryError, ExpiredLoginAuthCode, IPLoginRestrictionFailed, AccountLockedDown, AccountLogonDeniedVerifiedEmailRequired, NoMatchingURL, BadResponse, RequirePasswordReEntry, ValueOutOfRange, UnexpectedError, Disabled, InvalidCEGSubmission, RestrictedDevice, RegionLocked, RateLimitExceeded, AccountLoginDeniedNeedTwoFactor, ItemDeleted, AccountLoginDeniedThrottle, TwoFactorCodeMismatch, TwoFactorActivationCodeMismatch, AccountAssociatedToMultiplePartners, NotModified, NoMobileDevice, TimeNotSynced, SmsCodeFailed, AccountLimitExceeded, AccountActivityLimitExceeded, PhoneActivityLimitExceeded, RefundToWallet, EmailSendFailure, NotSettled, NeedCaptcha, GSLTDenied, GSOwnerDenied, InvalidItemType, IPBanned, GLSTExpired, UnknownErrorCode_NotImplementedByAPI};

    public static SteamResult[] values() {
        return (SteamResult[])$VALUES.clone();
    }

    private SteamResult(String var1, int var2, int var3) {
        this.code = var3;
    }

    public static SteamResult byValue(int var0) {
        return var0 < valuesLookupTable.length ? valuesLookupTable[var0] : UnknownErrorCode_NotImplementedByAPI;
    }

    static {
        SteamResult[] var0 = values();
        int var1 = 0;
        SteamResult[] var2 = var0;
        int var3 = var0.length;

        int var4;
        SteamResult var5;
        for(var4 = 0; var4 < var3; ++var4) {
            var5 = var2[var4];
            var1 = Math.max(var1, var5.code);
        }

        valuesLookupTable = new SteamResult[var1 + 1];
        var2 = var0;
        var3 = var0.length;

        for(var4 = 0; var4 < var3; ++var4) {
            var5 = var2[var4];
            valuesLookupTable[var5.code] = var5;
        }

    }
}
