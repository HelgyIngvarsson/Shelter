package application.controller;

import application.Main;
import application.model.Cell;
import application.model.FoodType;
import application.model.Pet;
import application.model.Ration;
import application.service.PetService;
import application.service.RationService;
import application.service.impl.PetServiceImpl;
import application.service.impl.RationServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ЖЛЗК on 11.06.2017.
 */
public class KeeperController implements Initializable {

    private PetService petService = new PetServiceImpl();
    private RationService service = new RationServiceImpl();

    BufferedImage bufferedImage;
    //File file = new File("C:/Users/ЖЛЗК/Desktop/test.jpg");

    @FXML
    TableView<Ration> keeperTable;
    @FXML
    TableColumn petC;
    @FXML
    TableColumn foodTypeC;
    @FXML
    TableColumn weightC;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        petC.setCellValueFactory(new PropertyValueFactory<Ration, Pet>("pet"));
        foodTypeC.setCellValueFactory(new PropertyValueFactory<Ration,FoodType>("foodType"));
        weightC.setCellValueFactory(new PropertyValueFactory<Pet, Double>("weight"));

        updateKeeperTable();
        bufferedImage = new BufferedImage(520   , 290, BufferedImage.TYPE_INT_ARGB);
    }

    private void updateKeeperTable()
    {
            keeperTable.getItems().clear();

            ObservableList<Ration> rations= FXCollections.observableArrayList();
            rations.addAll(service.findAllRationByKeeper((int)Main.getLogInWorker().getId()));
            for(int i=0;i<rations.size();i++)
                rations.get(i).setPet(petService.findPet(service.getPetId((int)rations.get(i).getId())));
            keeperTable.setItems(rations);

    }

    @FXML
    private void print()
    {
        WritableImage snapshot = keeperTable.snapshot(new SnapshotParameters(), null);
        BufferedImage image = saveImage(snapshot);
        printImage(image);
    }
    @FXML
    private void save() throws IOException {

        WritableImage snapshot = keeperTable.snapshot(new SnapshotParameters(), null);
        BufferedImage image = saveImage(snapshot);

        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image file", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showSaveDialog(new Stage());

        if(file != null){
            ImageIO.write(image, "png", file);
        }
    }



    private BufferedImage saveImage(WritableImage snapshot) {
        BufferedImage image;
        image = javafx.embed.swing.SwingFXUtils.fromFXImage(snapshot, bufferedImage);
        Graphics2D gd = (Graphics2D) image.getGraphics();
        gd.translate(keeperTable.getWidth(), keeperTable.getHeight());
        return image;
    }

    private void printImage(BufferedImage image) {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

                int x = (int) Math.ceil(pageFormat.getImageableX());
                int y = (int) Math.ceil(pageFormat.getImageableY());
                if (pageIndex != 0) {
                    return NO_SUCH_PAGE;
                }
                graphics.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);
                return PAGE_EXISTS;
            }
        });
        try {
            printJob.print();
        } catch (PrinterException e1) {
            e1.printStackTrace();
        }
    }
}
