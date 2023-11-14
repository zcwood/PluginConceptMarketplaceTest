import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HelloWorldAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        //Will display a window message
        Messages.showInfoMessage("Hey, Prof. Gusukuma, the plugin works! We are closer to a proof of concept now!", "CMSC 451 Action Triggered!");

        //my idea: create a new file, write the contents of the HelloWorld template to it, place in desktop
        File testFile = new File("/Users/zoewood/Desktop/test_file"); //create a file called test_file on desktop
        try {
            testFile.createNewFile();
            FileWriter writer = new FileWriter(testFile);
            writer.write("This is the file that was created by running the test plugin!");
            writer.flush(); //clear writer of any input
            writer.close();
        } catch (IOException ex) {
            System.out.println("FILE CREATION FAILED");
            throw new RuntimeException(ex);
        }
    }
}