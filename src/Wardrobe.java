public class Wardrobe {
    private int sections;
    private String color;
    private double height;

    public static class Builder {
        private final Wardrobe newWardrobe;


        public Builder() {
            newWardrobe = new Wardrobe();
        }

        public Builder withSections(int sections) {
            newWardrobe.sections = sections;
            return this;

        }

        public Builder withColor(String color) {
            newWardrobe.color = color;
            return this;
        }

        public Builder withHeight(double height) {
            newWardrobe.height = height;
            return this;
        }

        public Wardrobe build() {
            return newWardrobe;
        }
    }
    @Override
    public String toString(){
        return "Wardrobe with: "+"color "+color+",height "+height+",sections "+sections;
    }
}
