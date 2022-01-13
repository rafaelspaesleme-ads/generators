package br.com.rafaelspaesleme.generators;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

import static br.com.rafaelspaesleme.generators.CodesGenerator.exceptionNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReturnsGenerator {

    protected static class ReturnTwoParamDTO<P1, P2> {
        private final P1 param1;
        private final P2 param2;

        public ReturnTwoParamDTO(P1 param1, P2 param2) {
            this.param1 = param1;
            this.param2 = param2;
        }

        public P1 getParam1() {
            return param1;
        }

        public P2 getParam2() {
            return param2;
        }
    }

    protected static class ReturnThreeParamDTO<P1, P2, P3> {
        private final P1 param1;
        private final P2 param2;
        private final P3 param3;

        public ReturnThreeParamDTO(P1 param1, P2 param2, P3 param3) {
            this.param1 = param1;
            this.param2 = param2;
            this.param3 = param3;
        }

        public P1 getParam1() {
            return param1;
        }

        public P2 getParam2() {
            return param2;
        }

        public P3 getParam3() {
            return param3;
        }
    }

    protected static class ReturnFourParamDTO<P1, P2, P3, P4> {
        private final P1 param1;
        private final P2 param2;
        private final P3 param3;
        private final P4 param4;

        public ReturnFourParamDTO(P1 param1, P2 param2, P3 param3, P4 param4) {
            this.param1 = param1;
            this.param2 = param2;
            this.param3 = param3;
            this.param4 = param4;
        }

        public P1 getParam1() {
            return param1;
        }

        public P2 getParam2() {
            return param2;
        }

        public P3 getParam3() {
            return param3;
        }

        public P4 getParam4() {
            return param4;
        }
    }

    public static <ANY> Optional<?> ofAny(final ANY any) {
        return Optional.of(any);
    }

    public static <R1, R2> ReturnTwoParamDTO<R1, R2> ofTwo(final R1 return1, final R2 return2) {
        exceptionNull(return1);
        exceptionNull(return2);
        return new ReturnTwoParamDTO<>(return1, return2);
    }

    public static <R1, R2, R3> ReturnThreeParamDTO<R1, R2, R3> ofThree(final R1 return1, final R2 return2, final R3 return3) {
        exceptionNull(return1);
        exceptionNull(return2);
        exceptionNull(return3);
        return new ReturnThreeParamDTO<>(return1, return2, return3);
    }

    public static <R1, R2, R3, R4> ReturnFourParamDTO<R1, R2, R3, R4> ofFour(final R1 return1, final R2 return2, final R3 return3, final R4 return4) {
        exceptionNull(return1);
        exceptionNull(return2);
        exceptionNull(return3);
        exceptionNull(return4);
        return new ReturnFourParamDTO<>(return1, return2, return3, return4);
    }

}
