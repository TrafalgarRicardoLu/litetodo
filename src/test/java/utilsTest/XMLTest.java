package utilsTest;

import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.Uid;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import utils.UidGenerator;
import controller.xmlController;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XMLTest {
    @Test
    public void testDom() throws DocumentException {
        SAXReader reader = new SAXReader();
        File file = new File("/home/trafalgar/IdeaProjects/TRList/src/test/java/utilsTest/1.xml");
        Document document = reader.read(file);
        Element root = document.getRootElement();
        Element label = root.element("label");
        Element project = root.element("project");
        Element priority = root.element("priority");
        List<Element> filterLabel = label.elements();
        for (Element filter : filterLabel) {
            List<Element> uidList = filter.elements();
            System.out.println(filter.attribute("name").getData());
            for (Element uid : uidList) {
                System.out.println(uid.getText());
            }
        }
    }

    @Test
    public void testGetUids() throws DocumentException {
        xmlController xmlGenerator = new xmlController();
        List<String> uids = xmlGenerator.getUidsByFilterName("project", "TRList");
        if (uids == null) {
            System.out.println(1);
        }
        for (String uid : uids) {
            System.out.println(uid);
        }
    }

    @Test
    public void testAddUid() throws DocumentException, IOException {
        VEvent vEvent = new VEvent();
        UidGenerator uidGenerator = new UidGenerator();
        Uid uid = uidGenerator.generateUid();
        vEvent.getProperties().add(uid);
        xmlController.addUid("label", "shopping", vEvent);
    }

    @Test
    public void testDeleteUid() throws IOException, DocumentException {
        VEvent vEvent = new VEvent();
        UidGenerator uidGenerator = new UidGenerator();
        Uid uid = uidGenerator.generateUid();
        vEvent.getProperties().add(uid);
        xmlController.deleteUid("label", "shopping", vEvent);
    }
}