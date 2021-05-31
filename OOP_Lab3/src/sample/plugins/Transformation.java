package sample.plugins;

import javax.xml.bind.JAXBException;
import java.io.*;

public interface Transformation {
     String transform(String xml) throws IOException, JAXBException;
}
