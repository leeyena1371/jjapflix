package co.study.common.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class CommonCode {

    /**
     * Country enum
     */
    @RequiredArgsConstructor
    @Getter
    public enum Country{

        KR("kr");

        private final String value;
    }

    /**
     * Language enum
     */
    @RequiredArgsConstructor
    @Getter
    public enum Language{

        KO("ko");

        private final String value;
    }
}
