package bai3;

public class AC {
    private int temp = 25;
    private int newTemp ;
    private int oldTemp;

    public AC(int oldTemp, int newTemp, int temp) {
        this.oldTemp = oldTemp;
        this.newTemp = newTemp;
        this.temp = temp;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getNewTemp() {
        return newTemp;
    }

    public void setNewTemp(int newTemp) {
        this.newTemp = newTemp;
    }

    public int getOldTemp() {
        return oldTemp;
    }

    public void setOldTemp(int oldTemp) {
        this.oldTemp = oldTemp;
    }

    public void changeTemp(int newTemp){
        // lưu nhiệt đọ cũ
        this.oldTemp = this.newTemp;
        // lư nhiệt độ hiện tại
        temp = newTemp;
        //luưu nhiệt đọ mới
        this.newTemp = newTemp;
    }
}
