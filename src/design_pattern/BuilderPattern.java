package design_pattern;

public class BuilderPattern {
    public static void main(String ar[]) {
        Computer mac = new Computer.ComputerBuilder("500 GB", "8 GB", 11).setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true).build();

        System.out.println(mac.toString());
    }
}

class Computer {
    //required parameters
    private String HDD;
    private String RAM;
    private int validity;

    //optional parameters
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    @Override
    public String toString() {
        return this.HDD +" "+ this.RAM +" "+ this.validity +" "+ this.isGraphicsCardEnabled +" "+ this.isBluetoothEnabled;
    }

    private Computer(ComputerBuilder computerBuilder) {
        this.HDD = computerBuilder.HDD;
        this.RAM = computerBuilder.RAM;
        this.validity = computerBuilder.validity;
        this.isGraphicsCardEnabled = computerBuilder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = computerBuilder.isBluetoothEnabled;
    }

    // Builder class or subclass
    public static class ComputerBuilder {
        //required parameters
        private String HDD;
        private String RAM;
        private int validity;

        //optional parameters
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String HDD, String RAM, int validity) {
            this.HDD = HDD;
            this.RAM = RAM;
            this.validity = validity;
        }

        public ComputerBuilder setGraphicsCardEnabled(boolean graphicsCardEnabled) {
            this.isGraphicsCardEnabled = graphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean bluetoothEnabled) {
            isBluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public Computer build() {
            if(this.validity < 10) {
                throw new RuntimeException("validity should be greater than 10");
            }
            return new Computer(this);
        }

    }
}