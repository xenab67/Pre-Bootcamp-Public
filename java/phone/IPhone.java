public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String Ring() {
        return this.getRingtone();
    }
    @Override
    public String unlock() {
        return "Face recognition activating....Unlocking IPhone";
    }
    @Override
    public void displayInfo() {
        System.out.println("Version Number:" + this.getVersionNumber());
        System.out.println("Battery Percentage:" + this.getBatteryPercentage());
        System.out.println("Carrier:" + this.getCarrier());
        System.out.println("Ringtone:" + this.getRingtone());
    }
}
