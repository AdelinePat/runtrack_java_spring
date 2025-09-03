    package day2.demoDay2.Controller;

    import jakarta.validation.constraints.Max;
    import jakarta.validation.constraints.Min;
    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.NotNull;


    public class ValidForm {
        @NotBlank(message = "le champ nom est obligatoire")
        private String welcome;

        @NotBlank(message = "le champ else est obligatoire")
        private String anotherField;

        @NotNull(message = "le champ âge est obligatoire")
        @Min(value = 0, message = "l'âge doit être positif")
        @Max(value = 120, message = "moque toi de moi, vieille branche!")
        private Integer age;


        public void setWelcome(String welcome) { this.welcome = welcome; }
        public void setAnotherField(String anotherField) { this.anotherField = anotherField; }
        public void setAge(Integer age) { this.age = age; }


        public String getWelcome() {
            return welcome;
        }

        public String getAnotherField() {
            return anotherField;
        }

        public Integer getAge() {
            return age;
        }
    }
