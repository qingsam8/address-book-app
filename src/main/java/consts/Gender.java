package consts;

public enum Gender {
    MALE,
    FEMALE;

    public static Gender fromString(String genderText) {
        if(genderText.toLowerCase().equals("male")) {
            return MALE;
        } else if (genderText.toLowerCase().equals("female")) {
            return FEMALE;
        } else {
            throw new IllegalArgumentException(String.format("gender must be %s. But got %s",
                                               java.util.Arrays.asList(Gender.values()).toString(),
                                               genderText));
        }
    }
}
