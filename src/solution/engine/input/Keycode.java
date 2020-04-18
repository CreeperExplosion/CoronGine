package solution.engine.input;


public class Keycode{
    private Keycode() {
    }

    /** Constant for the ENTER virtual key. */
    public static final int ENTER          = '\n';

    /** Constant for the BACK_SPACE virtual key. */
    public static final int BACK_SPACE     = '\b';

    /** Constant for the TAB virtual key. */
    public static final int TAB            = '\t';

    /** Constant for the CANCEL virtual key. */
    public static final int CANCEL         = 0x03;

    /** Constant for the CLEAR virtual key. */
    public static final int CLEAR          = 0x0C;

    /** Constant for the SHIFT virtual key. */
    public static final int SHIFT          = 0x10;

    /** Constant for the CONTROL virtual key. */
    public static final int CONTROL        = 0x11;

    /** Constant for the ALT virtual key. */
    public static final int ALT            = 0x12;

    /** Constant for the PAUSE virtual key. */
    public static final int PAUSE          = 0x13;

    /** Constant for the CAPS_LOCK virtual key. */
    public static final int CAPS_LOCK      = 0x14;

    /** Constant for the ESCAPE virtual key. */
    public static final int ESCAPE         = 0x1B;

    /** Constant for the SPACE virtual key. */
    public static final int SPACE          = 0x20;

    /** Constant for the PAGE_UP virtual key. */
    public static final int PAGE_UP        = 0x21;

    /** Constant for the PAGE_DOWN virtual key. */
    public static final int PAGE_DOWN      = 0x22;

    /** Constant for the END virtual key. */
    public static final int END            = 0x23;

    /** Constant for the HOME virtual key. */
    public static final int HOME           = 0x24;

    /**
     * Constant for the non-numpad <b>left</b> arrow key.
     * @see #KP_LEFT
     */
    public static final int LEFT           = 0x25;

    /**
     * Constant for the non-numpad <b>up</b> arrow key.
     * @see #KP_UP
     */
    public static final int UP             = 0x26;

    /**
     * Constant for the non-numpad <b>right</b> arrow key.
     * @see #KP_RIGHT
     */
    public static final int RIGHT          = 0x27;

    /**
     * Constant for the non-numpad <b>down</b> arrow key.
     * @see #KP_DOWN
     */
    public static final int DOWN           = 0x28;

    /**
     * Constant for the comma key, ","
     */
    public static final int COMMA          = 0x2C;

    /**
     * Constant for the minus key, "-"
     * @since 1.2
     */
    public static final int MINUS          = 0x2D;

    /**
     * Constant for the period key, "."
     */
    public static final int PERIOD         = 0x2E;

    /**
     * Constant for the forward slash key, "/"
     */
    public static final int SLASH          = 0x2F;

    /** 0 thru 9 are the same as ASCII '0' thru '9' (0x30 - 0x39) */

    /** Constant for the "0" key. */
    public static final int NUM_0              = 0x30;

    /** Constant for the "1" key. */
    public static final int NUM_1              = 0x31;

    /** Constant for the "2" key. */
    public static final int NUM_2              = 0x32;

    /** Constant for the "3" key. */
    public static final int NUM_3              = 0x33;

    /** Constant for the "4" key. */
    public static final int NUM_4              = 0x34;

    /** Constant for the "5" key. */
    public static final int NUM_5              = 0x35;

    /** Constant for the "6" key. */
    public static final int NUM_6              = 0x36;

    /** Constant for the "7" key. */
    public static final int NUM_7              = 0x37;

    /** Constant for the "8" key. */
    public static final int NUM_8              = 0x38;

    /** Constant for the "9" key. */
    public static final int NUM_9              = 0x39;

    /**
     * Constant for the semicolon key, ";"
     */
    public static final int SEMICOLON      = 0x3B;

    /**
     * Constant for the equals key, "="
     */
    public static final int EQUALS         = 0x3D;

    /** A thru Z are the same as ASCII 'A' thru 'Z' (0x41 - 0x5A) */

    /** Constant for the "A" key. */
    public static final int A              = 0x41;

    /** Constant for the "B" key. */
    public static final int B              = 0x42;

    /** Constant for the "C" key. */
    public static final int C              = 0x43;

    /** Constant for the "D" key. */
    public static final int D              = 0x44;

    /** Constant for the "E" key. */
    public static final int E              = 0x45;

    /** Constant for the "F" key. */
    public static final int F              = 0x46;

    /** Constant for the "G" key. */
    public static final int G              = 0x47;

    /** Constant for the "H" key. */
    public static final int H              = 0x48;

    /** Constant for the "I" key. */
    public static final int I              = 0x49;

    /** Constant for the "J" key. */
    public static final int J              = 0x4A;

    /** Constant for the "K" key. */
    public static final int K              = 0x4B;

    /** Constant for the "L" key. */
    public static final int L              = 0x4C;

    /** Constant for the "M" key. */
    public static final int M              = 0x4D;

    /** Constant for the "N" key. */
    public static final int N              = 0x4E;

    /** Constant for the "O" key. */
    public static final int O              = 0x4F;

    /** Constant for the "P" key. */
    public static final int P              = 0x50;

    /** Constant for the "Q" key. */
    public static final int Q              = 0x51;

    /** Constant for the "R" key. */
    public static final int R              = 0x52;

    /** Constant for the "S" key. */
    public static final int S              = 0x53;

    /** Constant for the "T" key. */
    public static final int T              = 0x54;

    /** Constant for the "U" key. */
    public static final int U              = 0x55;

    /** Constant for the "V" key. */
    public static final int V              = 0x56;

    /** Constant for the "W" key. */
    public static final int W              = 0x57;

    /** Constant for the "X" key. */
    public static final int X              = 0x58;

    /** Constant for the "Y" key. */
    public static final int Y              = 0x59;

    /** Constant for the "Z" key. */
    public static final int Z              = 0x5A;

    /**
     * Constant for the open bracket key, "["
     */
    public static final int OPEN_BRACKET   = 0x5B;

    /**
     * Constant for the back slash key, "\"
     */
    public static final int BACK_SLASH     = 0x5C;

    /**
     * Constant for the close bracket key, "]"
     */
    public static final int CLOSE_BRACKET  = 0x5D;

    /** Constant for the number pad "0" key. */
    public static final int NUMPAD0        = 0x60;

    /** Constant for the number pad "1" key. */
    public static final int NUMPAD1        = 0x61;

    /** Constant for the number pad "2" key. */
    public static final int NUMPAD2        = 0x62;

    /** Constant for the number pad "3" key. */
    public static final int NUMPAD3        = 0x63;

    /** Constant for the number pad "4" key. */
    public static final int NUMPAD4        = 0x64;

    /** Constant for the number pad "5" key. */
    public static final int NUMPAD5        = 0x65;

    /** Constant for the number pad "6" key. */
    public static final int NUMPAD6        = 0x66;

    /** Constant for the number pad "7" key. */
    public static final int NUMPAD7        = 0x67;

    /** Constant for the number pad "8" key. */
    public static final int NUMPAD8        = 0x68;

    /** Constant for the number pad "9" key. */
    public static final int NUMPAD9        = 0x69;

    /** Constant for the number pad multiply key. */
    public static final int MULTIPLY       = 0x6A;

    /** Constant for the number pad add key. */
    public static final int ADD            = 0x6B;

    /**
     * This constant is obsolete, and is included only for backwards
     * compatibility.
     * @see #SEPARATOR
     */
    public static final int SEPARATER      = 0x6C;

    /**
     * Constant for the Numpad Separator key.
     * @since 1.4
     */
    public static final int SEPARATOR      = SEPARATER;

    /** Constant for the number pad subtract key. */
    public static final int SUBTRACT       = 0x6D;

    /** Constant for the number pad decimal point key. */
    public static final int DECIMAL        = 0x6E;

    /** Constant for the number pad divide key. */
    public static final int DIVIDE         = 0x6F;

    /** Constant for the delete key. */
    public static final int DELETE         = 0x7F; /* ASCII DEL */

    /** Constant for the NUM_LOCK key. */
    public static final int NUM_LOCK       = 0x90;

    /** Constant for the SCROLL_LOCK key. */
    public static final int SCROLL_LOCK    = 0x91;

    /** Constant for the F1 function key. */
    public static final int F1             = 0x70;

    /** Constant for the F2 function key. */
    public static final int F2             = 0x71;

    /** Constant for the F3 function key. */
    public static final int F3             = 0x72;

    /** Constant for the F4 function key. */
    public static final int F4             = 0x73;

    /** Constant for the F5 function key. */
    public static final int F5             = 0x74;

    /** Constant for the F6 function key. */
    public static final int F6             = 0x75;

    /** Constant for the F7 function key. */
    public static final int F7             = 0x76;

    /** Constant for the F8 function key. */
    public static final int F8             = 0x77;

    /** Constant for the F9 function key. */
    public static final int F9             = 0x78;

    /** Constant for the F10 function key. */
    public static final int F10            = 0x79;

    /** Constant for the F11 function key. */
    public static final int F11            = 0x7A;

    /** Constant for the F12 function key. */
    public static final int F12            = 0x7B;

    /**
     * Constant for the F13 function key.
     * @since 1.2
     */
    /* F13 - F24 are used on IBM 3270 keyboard; use random range for constants. */
    public static final int F13            = 0xF000;

    /**
     * Constant for the F14 function key.
     * @since 1.2
     */
    public static final int F14            = 0xF001;

    /**
     * Constant for the F15 function key.
     * @since 1.2
     */
    public static final int F15            = 0xF002;

    /**
     * Constant for the F16 function key.
     * @since 1.2
     */
    public static final int F16            = 0xF003;

    /**
     * Constant for the F17 function key.
     * @since 1.2
     */
    public static final int F17            = 0xF004;

    /**
     * Constant for the F18 function key.
     * @since 1.2
     */
    public static final int F18            = 0xF005;

    /**
     * Constant for the F19 function key.
     * @since 1.2
     */
    public static final int F19            = 0xF006;

    /**
     * Constant for the F20 function key.
     * @since 1.2
     */
    public static final int F20            = 0xF007;

    /**
     * Constant for the F21 function key.
     * @since 1.2
     */
    public static final int F21            = 0xF008;

    /**
     * Constant for the F22 function key.
     * @since 1.2
     */
    public static final int F22            = 0xF009;

    /**
     * Constant for the F23 function key.
     * @since 1.2
     */
    public static final int F23            = 0xF00A;

    /**
     * Constant for the F24 function key.
     * @since 1.2
     */
    public static final int F24            = 0xF00B;

    /**  Constant for the PRINTSCREEN key. */
    public static final int PRINTSCREEN    = 0x9A;

    /**  Constant for the INSERT key. */
    public static final int INSERT         = 0x9B;

    /**  Constant for the HELP key. */
    public static final int HELP           = 0x9C;

    /**  Constant for the META key. */
    public static final int META           = 0x9D;

    /**  Constant for the BACK_QUOTE  key. */
    public static final int BACK_QUOTE     = 0xC0;

    /**  Constant for the QUOTE key. */
    public static final int QUOTE          = 0xDE;

    /**
     * Constant for the numeric keypad <b>up</b> arrow key.
     * @see #UP
     * @since 1.2
     */
    public static final int KP_UP          = 0xE0;

    /**
     * Constant for the numeric keypad <b>down</b> arrow key.
     * @see #DOWN
     * @since 1.2
     */
    public static final int KP_DOWN        = 0xE1;

    /**
     * Constant for the numeric keypad <b>left</b> arrow key.
     * @see #LEFT
     * @since 1.2
     */
    public static final int KP_LEFT        = 0xE2;

    /**
     * Constant for the numeric keypad <b>right</b> arrow key.
     * @see #RIGHT
     * @since 1.2
     */
    public static final int KP_RIGHT       = 0xE3;

    /* For European keyboards */
    /** @since 1.2 */
    public static final int DEAD_GRAVE               = 0x80;
    /** @since 1.2 */
    public static final int DEAD_ACUTE               = 0x81;
    /** @since 1.2 */
    public static final int DEAD_CIRCUMFLEX          = 0x82;
    /** @since 1.2 */
    public static final int DEAD_TILDE               = 0x83;
    /** @since 1.2 */
    public static final int DEAD_MACRON              = 0x84;
    /** @since 1.2 */
    public static final int DEAD_BREVE               = 0x85;
    /** @since 1.2 */
    public static final int DEAD_ABOVEDOT            = 0x86;
    /** @since 1.2 */
    public static final int DEAD_DIAERESIS           = 0x87;
    /** @since 1.2 */
    public static final int DEAD_ABOVERING           = 0x88;
    /** @since 1.2 */
    public static final int DEAD_DOUBLEACUTE         = 0x89;
    /** @since 1.2 */
    public static final int DEAD_CARON               = 0x8a;
    /** @since 1.2 */
    public static final int DEAD_CEDILLA             = 0x8b;
    /** @since 1.2 */
    public static final int DEAD_OGONEK              = 0x8c;
    /** @since 1.2 */
    public static final int DEAD_IOTA                = 0x8d;
    /** @since 1.2 */
    public static final int DEAD_VOICED_SOUND        = 0x8e;
    /** @since 1.2 */
    public static final int DEAD_SEMIVOICED_SOUND    = 0x8f;

    /** @since 1.2 */
    public static final int AMPERSAND                = 0x96;
    /** @since 1.2 */
    public static final int ASTERISK                 = 0x97;
    /** @since 1.2 */
    public static final int QUOTEDBL                 = 0x98;
    /** @since 1.2 */
    public static final int LESS                     = 0x99;

    /** @since 1.2 */
    public static final int GREATER                  = 0xa0;
    /** @since 1.2 */
    public static final int BRACELEFT                = 0xa1;
    /** @since 1.2 */
    public static final int BRACERIGHT               = 0xa2;

    /**
     * Constant for the "@" key.
     * @since 1.2
     */
    public static final int AT                       = 0x0200;

    /**
     * Constant for the ":" key.
     * @since 1.2
     */
    public static final int COLON                    = 0x0201;

    /**
     * Constant for the "^" key.
     * @since 1.2
     */
    public static final int CIRCUMFLEX               = 0x0202;

    /**
     * Constant for the "$" key.
     * @since 1.2
     */
    public static final int DOLLAR                   = 0x0203;

    /**
     * Constant for the Euro currency sign key.
     * @since 1.2
     */
    public static final int EURO_SIGN                = 0x0204;

    /**
     * Constant for the "!" key.
     * @since 1.2
     */
    public static final int EXCLAMATION_MARK         = 0x0205;

    /**
     * Constant for the inverted exclamation mark key.
     * @since 1.2
     */
    public static final int INVERTED_EXCLAMATION_MARK = 0x0206;

    /**
     * Constant for the "(" key.
     * @since 1.2
     */
    public static final int LEFT_PARENTHESIS         = 0x0207;

    /**
     * Constant for the "#" key.
     * @since 1.2
     */
    public static final int NUMBER_SIGN              = 0x0208;

    /**
     * Constant for the "+" key.
     * @since 1.2
     */
    public static final int PLUS                     = 0x0209;

    /**
     * Constant for the ")" key.
     * @since 1.2
     */
    public static final int RIGHT_PARENTHESIS        = 0x020A;

    /**
     * Constant for the "_" key.
     * @since 1.2
     */
    public static final int UNDERSCORE               = 0x020B;

    /**
     * Constant for the Microsoft Windows "Windows" key.
     * It is used for both the left and right version of the key.
     * @see #getKeyLocation()
     * @since 1.5
     */
    public static final int WINDOWS                  = 0x020C;

    /**
     * Constant for the Microsoft Windows Context Menu key.
     * @since 1.5
     */
    public static final int CONTEXT_MENU             = 0x020D;

    /* for input method support on Asian Keyboards */

    /* not clear what this means - listed in Microsoft Windows API */
    /** Constant for the FINAL key. */
    public static final int FINAL                    = 0x0018;

    /** Constant for the Convert function key. */
    /* Japanese PC 106 keyboard, Japanese Solaris keyboard: henkan */
    public static final int CONVERT                  = 0x001C;

    /** Constant for the Don't Convert function key. */
    /* Japanese PC 106 keyboard: muhenkan */
    public static final int NONCONVERT               = 0x001D;

    /** Constant for the Accept or Commit function key. */
    /* Japanese Solaris keyboard: kakutei */
    public static final int ACCEPT                   = 0x001E;

    /* not clear what this means - listed in Microsoft Windows API */
    /** Constant for the MODECHANGE key. */
    public static final int MODECHANGE               = 0x001F;
}