package groomery.groomerywithmaven.models;

public enum Treatment {
    SZÁRÍTÁS("Hosszú és rövidszőrű kutyáknak", true){
        @Override
        public String getTreatmentDescription() {
            return "Ha vizes, megszárítjuk!";
        }
    },
    VÁGÁS("Hosszú és rövidszőrű kutyáknak", true) {
        @Override
        public String getTreatmentDescription() {
            return "Jól levágjuk a szőrét!";
        }
    },
    KÖRÖMVÁGÁS("csak kistestűeknek", false) {
        @Override
        public String getTreatmentDescription() {
            return "Levágjkuk a körmét";
        }
    },
    FOGKŐLESZEDÉS("csak kistestűeknek", false) {
        @Override
        public String getTreatmentDescription() {
            return "Fogkőtelenítünk ultrahanggal.";
        }
    };

    public final String dogType;
    public final boolean forEveryDog;

    Treatment(String dogType, boolean forEveryDog) {
        this.dogType = dogType;
        this.forEveryDog = forEveryDog;
    }

    public abstract String getTreatmentDescription();


}
