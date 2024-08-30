package com.codedisaster.steamworks;

public final class SteamHTTP$HTTPStatusCode {
    public static final SteamHTTP$HTTPStatusCode Invalid = new SteamHTTP$HTTPStatusCode("Invalid", 0, 0);
    public static final SteamHTTP$HTTPStatusCode Continue = new SteamHTTP$HTTPStatusCode("Continue", 1, 100);
    public static final SteamHTTP$HTTPStatusCode SwitchingProtocols = new SteamHTTP$HTTPStatusCode("SwitchingProtocols", 2, 101);
    public static final SteamHTTP$HTTPStatusCode OK = new SteamHTTP$HTTPStatusCode("OK", 3, 200);
    public static final SteamHTTP$HTTPStatusCode Created = new SteamHTTP$HTTPStatusCode("Created", 4, 201);
    public static final SteamHTTP$HTTPStatusCode Accepted = new SteamHTTP$HTTPStatusCode("Accepted", 5, 202);
    public static final SteamHTTP$HTTPStatusCode NonAuthoritative = new SteamHTTP$HTTPStatusCode("NonAuthoritative", 6, 203);
    public static final SteamHTTP$HTTPStatusCode NoContent = new SteamHTTP$HTTPStatusCode("NoContent", 7, 204);
    public static final SteamHTTP$HTTPStatusCode ResetContent = new SteamHTTP$HTTPStatusCode("ResetContent", 8, 205);
    public static final SteamHTTP$HTTPStatusCode PartialContent = new SteamHTTP$HTTPStatusCode("PartialContent", 9, 206);
    public static final SteamHTTP$HTTPStatusCode MultipleChoices = new SteamHTTP$HTTPStatusCode("MultipleChoices", 10, 300);
    public static final SteamHTTP$HTTPStatusCode MovedPermanently = new SteamHTTP$HTTPStatusCode("MovedPermanently", 11, 301);
    public static final SteamHTTP$HTTPStatusCode Found = new SteamHTTP$HTTPStatusCode("Found", 12, 302);
    public static final SteamHTTP$HTTPStatusCode SeeOther = new SteamHTTP$HTTPStatusCode("SeeOther", 13, 303);
    public static final SteamHTTP$HTTPStatusCode NotModified = new SteamHTTP$HTTPStatusCode("NotModified", 14, 304);
    public static final SteamHTTP$HTTPStatusCode UseProxy = new SteamHTTP$HTTPStatusCode("UseProxy", 15, 305);
    public static final SteamHTTP$HTTPStatusCode TemporaryRedirect = new SteamHTTP$HTTPStatusCode("TemporaryRedirect", 16, 307);
    public static final SteamHTTP$HTTPStatusCode BadRequest = new SteamHTTP$HTTPStatusCode("BadRequest", 17, 400);
    public static final SteamHTTP$HTTPStatusCode Unauthorized = new SteamHTTP$HTTPStatusCode("Unauthorized", 18, 401);
    public static final SteamHTTP$HTTPStatusCode PaymentRequired = new SteamHTTP$HTTPStatusCode("PaymentRequired", 19, 402);
    public static final SteamHTTP$HTTPStatusCode Forbidden = new SteamHTTP$HTTPStatusCode("Forbidden", 20, 403);
    public static final SteamHTTP$HTTPStatusCode NotFound = new SteamHTTP$HTTPStatusCode("NotFound", 21, 404);
    public static final SteamHTTP$HTTPStatusCode MethodNotAllowed = new SteamHTTP$HTTPStatusCode("MethodNotAllowed", 22, 405);
    public static final SteamHTTP$HTTPStatusCode NotAcceptable = new SteamHTTP$HTTPStatusCode("NotAcceptable", 23, 406);
    public static final SteamHTTP$HTTPStatusCode ProxyAuthRequired = new SteamHTTP$HTTPStatusCode("ProxyAuthRequired", 24, 407);
    public static final SteamHTTP$HTTPStatusCode RequestTimeout = new SteamHTTP$HTTPStatusCode("RequestTimeout", 25, 408);
    public static final SteamHTTP$HTTPStatusCode Conflict = new SteamHTTP$HTTPStatusCode("Conflict", 26, 409);
    public static final SteamHTTP$HTTPStatusCode Gone = new SteamHTTP$HTTPStatusCode("Gone", 27, 410);
    public static final SteamHTTP$HTTPStatusCode LengthRequired = new SteamHTTP$HTTPStatusCode("LengthRequired", 28, 411);
    public static final SteamHTTP$HTTPStatusCode PreconditionFailed = new SteamHTTP$HTTPStatusCode("PreconditionFailed", 29, 412);
    public static final SteamHTTP$HTTPStatusCode RequestEntityTooLarge = new SteamHTTP$HTTPStatusCode("RequestEntityTooLarge", 30, 413);
    public static final SteamHTTP$HTTPStatusCode RequestURITooLong = new SteamHTTP$HTTPStatusCode("RequestURITooLong", 31, 414);
    public static final SteamHTTP$HTTPStatusCode UnsupportedMediaType = new SteamHTTP$HTTPStatusCode("UnsupportedMediaType", 32, 415);
    public static final SteamHTTP$HTTPStatusCode RequestedRangeNotSatisfiable = new SteamHTTP$HTTPStatusCode("RequestedRangeNotSatisfiable", 33, 416);
    public static final SteamHTTP$HTTPStatusCode ExpectationFailed = new SteamHTTP$HTTPStatusCode("ExpectationFailed", 34, 417);
    public static final SteamHTTP$HTTPStatusCode Unknown4xx = new SteamHTTP$HTTPStatusCode("Unknown4xx", 35, 418);
    public static final SteamHTTP$HTTPStatusCode TooManyRequests = new SteamHTTP$HTTPStatusCode("TooManyRequests", 36, 429);
    public static final SteamHTTP$HTTPStatusCode InternalServerError = new SteamHTTP$HTTPStatusCode("InternalServerError", 37, 500);
    public static final SteamHTTP$HTTPStatusCode NotImplemented = new SteamHTTP$HTTPStatusCode("NotImplemented", 38, 501);
    public static final SteamHTTP$HTTPStatusCode BadGateway = new SteamHTTP$HTTPStatusCode("BadGateway", 39, 502);
    public static final SteamHTTP$HTTPStatusCode ServiceUnavailable = new SteamHTTP$HTTPStatusCode("ServiceUnavailable", 40, 503);
    public static final SteamHTTP$HTTPStatusCode GatewayTimeout = new SteamHTTP$HTTPStatusCode("GatewayTimeout", 41, 504);
    public static final SteamHTTP$HTTPStatusCode HTTPVersionNotSupported = new SteamHTTP$HTTPStatusCode("HTTPVersionNotSupported", 42, 505);
    public static final SteamHTTP$HTTPStatusCode Unknown5xx = new SteamHTTP$HTTPStatusCode("Unknown5xx", 43, 599);
    private final int code;
    private static final SteamHTTP$HTTPStatusCode[] values = values();
    // $FF: synthetic field
    private static final SteamHTTP$HTTPStatusCode[] $VALUES = new SteamHTTP$HTTPStatusCode[]{Invalid, Continue, SwitchingProtocols, OK, Created, Accepted, NonAuthoritative, NoContent, ResetContent, PartialContent, MultipleChoices, MovedPermanently, Found, SeeOther, NotModified, UseProxy, TemporaryRedirect, BadRequest, Unauthorized, PaymentRequired, Forbidden, NotFound, MethodNotAllowed, NotAcceptable, ProxyAuthRequired, RequestTimeout, Conflict, Gone, LengthRequired, PreconditionFailed, RequestEntityTooLarge, RequestURITooLong, UnsupportedMediaType, RequestedRangeNotSatisfiable, ExpectationFailed, Unknown4xx, TooManyRequests, InternalServerError, NotImplemented, BadGateway, ServiceUnavailable, GatewayTimeout, HTTPVersionNotSupported, Unknown5xx};

    public static SteamHTTP$HTTPStatusCode[] values() {
        return (SteamHTTP$HTTPStatusCode[])$VALUES.clone();
    }

    private SteamHTTP$HTTPStatusCode(String var1, int var2, int var3) {
        this.code = var3;
    }

    static SteamHTTP$HTTPStatusCode byValue(int var0) {
        SteamHTTP$HTTPStatusCode[] var1 = values;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            SteamHTTP$HTTPStatusCode var4 = var1[var3];
            if (var4.code == var0) {
                return var4;
            }
        }

        return Invalid;
    }
}
