package by.tc.task01.entity;
// а куда пропали equals и hashCode?
public class Refrigerator extends Appliance{
    String powerConsumption,// ну и что это за оббъявление полей экземпляра класса?
    weight, // кто не смотрел Java Code Convention?
    freezerCapacity,
    overallCapacity,
    height,
    width;// не жалей пробелов в коде и нормально его форматируй, такие недочеты тоже являются ошибками и за них я снимаю баллы
    public Refrigerator(){}
    public Refrigerator(String ... args){// вот скажи, ты сам таким конструктором захочешь пользоваться - нет, рабираться надо и не ошибиться с параметрами - зачем тогда пишешь?
        this.powerConsumption = args[0];
        this.weight = args[1];
        this.freezerCapacity = args[2];
        this.overallCapacity = args[3];
        this.height = args[4];
        this.width = args[5];
    }

    public String getPowerConsumption(){ return this.powerConsumption; }
    public String getWeight(){ return this.weight; }
    public String getFreezerCapacity(){ return this.freezerCapacity; }
    public String getOverallCapacity(){ return this.overallCapacity; }
    public String getHeight(){ return this.height; }
    public String getWidth(){ return this.width; }

    public void setPowerConsumption(String value){ this.powerConsumption = value; }
    public void setWeight(String value){ this.weight = value; }
    public void setFreezerCapacity(String value){ this.freezerCapacity = value; }
    public void setOverallCapacity(String value){ this.overallCapacity = value; }
    public void setHeight(String value){ this.height = value; }
    public void setWidth(String value){ this.width = value; }

    // you may add your own code here //удалять такое надо, сдаешь, ведь проект
}
