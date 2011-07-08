package ee.ignorance.transformiceapi.titles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

@XmlRootElement(name = "titles")
class TitleReader {
    private static final Logger logger = Logger.getLogger(TitleReader.class);
    private static final String file = "titles.xml";

    @XmlElement(name = "title")
    List<Title> titleList;

    static Map<Integer, Title> read() {
        Map<Integer, Title> map = new HashMap<Integer, Title>();
        try {
            JAXBContext jc = JAXBContext.newInstance(TitleReader.class);
            Unmarshaller u = jc.createUnmarshaller();
            InputStream in = ClassLoader.getSystemResourceAsStream(file);
            if (in == null) {
                throw new FileNotFoundException("File not found " + file);
            }
            
            TitleReader reader = (TitleReader) u.unmarshal(in);
            for (Title t : reader.titleList) {
                map.put(t.getId(), t);
            }
        } catch (JAXBException e) {
            logger.warn("Failed to read titles", e);
        } catch (IOException e) {
            logger.warn("File not found: " + file);
        }
        
        logger.debug(map.size() + " titles read from " + file);
        return map;
    }
}