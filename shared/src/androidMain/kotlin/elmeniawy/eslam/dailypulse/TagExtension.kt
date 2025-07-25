package elmeniawy.eslam.dailypulse

/**
 * TagExtension
 *
 * Created by Eslam El-Meniawy on 13-Jul-2025 at 3:28 PM.
 */

val Any.TAG: String
    get() {
        return if (!javaClass.isAnonymousClass) {
            val name = javaClass.simpleName

            if (name.length <= 23) name else name.substring(0, 23)// first 23 chars
        } else {
            val name = javaClass.name

            if (name.length <= 23) name else name.substring(
                name.length - 23,
                name.length
            )// last 23 chars
        }
    }