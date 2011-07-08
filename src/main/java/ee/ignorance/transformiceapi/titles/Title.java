package ee.ignorance.transformiceapi.titles;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "title")
public class Title {

    @XmlElement(name = "id", required = true) 
    private int id;
    
    @XmlElement(name = "requirement")
    private int requirement;
    
    @XmlAttribute(name = "type", required = true)
    private TitleType type;
    
    @XmlElement(name = "en")
    private String en;
    
    @XmlElement(name = "fr")
    private String fr;
    
    @XmlElement(name = "pt")
    private String pt;
    
    @XmlElement(name = "ru")
    private String ru;

    public int getId() {
        return id;
    }

    public TitleType getType() {
        return type;
    }

    public int getRequirement() {
        return requirement;
    }

    public String getEn() {
        return en;
    }

    public String getFr() {
        return fr;
    }

    public String getPt() {
        return pt;
    }

    public String getRu() {
        return ru;
    }

    void setId(int id) {
        this.id = id;
    }

    void setType(TitleType type) {
        this.type = type;
    }

    void setRequirement(int requirement) {
        this.requirement = requirement;
    }

    void setEn(String en) {
        this.en = en;
    }

    void setFr(String fr) {
        this.fr = fr;
    }

    void setPt(String pt) {
        this.pt = pt;
    }

    void setRu(String ru) {
        this.ru = ru;
    }

    
    @Override
    public String toString() {
        return "Title [id=" + id + ", type=" + type + ", requirement=" + requirement + ", en=" + en +"]";
    }
}