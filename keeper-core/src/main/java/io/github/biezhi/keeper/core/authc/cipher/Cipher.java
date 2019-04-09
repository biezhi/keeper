package io.github.biezhi.keeper.core.authc.cipher;

import io.github.biezhi.keeper.core.authc.AuthenticInfo;
import io.github.biezhi.keeper.core.authc.AuthorToken;

/**
 * Cipher
 *
 * @author biezhi
 * @since 2019/4/9
 */
public interface Cipher {

    Cipher MD5    = new CipherMd5();
    Cipher EQUALS = new CipherEquals();

    boolean verify(AuthorToken token, AuthenticInfo authenticInfo);

    default String tokenCipher(AuthorToken token) {
        if (null == token) {
            return null;
        }
        return token.password();
    }

    default String authenticCipher(AuthenticInfo token) {
        if (null == token) {
            return null;
        }
        return token.password();
    }

}
