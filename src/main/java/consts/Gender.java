package consts;

public enum Gender {
    MALE,
    FEMALE;

    /**
     * Returns the Gender based on the string
     * @param genderText the string
     * @return the Gender
     */
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
