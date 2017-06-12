package application.controller;

import application.Main;
import application.model.MedObserv;
import application.model.Pet;
import application.model.Worker;
import application.service.MedObservService;
import application.service.PetService;
import application.service.impl.MedObservServiceImpl;
import application.service.impl.PetServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Created by ЖЛЗК on 11.06.2017.
 */
public class VetController implements Initializable {

    private PetService petService = new PetServiceImpl();

    private MedObservService medObservService = new MedObservServiceImpl();

    @FXML
    ListView<Pet> petList;

    @FXML
    TableView<MedObserv> observTable;

    @FXML
    Label dateLabel;

    @FXML
    TableColumn dateC;
    @FXML
    TableColumn idC;
    @FXML
    TableColumn conclusionC;
    @FXML
    TableColumn vetC;

    @FXML
    TextArea conclusionTA;

    @FXML
    DatePicker observDatePicker;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dateC.setCellValueFactory(new PropertyValueFactory<MedObserv, Date>("date"));
        idC.setCellValueFactory(new PropertyValueFactory<MedObserv,Integer>("id"));
        conclusionC.setCellValueFactory(new PropertyValueFactory<MedObserv,String>("conclusion"));
        vetC.setCellValueFactory(new PropertyValueFactory<MedObserv, Worker>("worker"));

        ObservableList<Pet> pets= FXCollections.observableArrayList();
        pets.addAll(petService.findAllPet());
        petList.setItems(pets);

    }


    @FXML
    private void transact(ActionEvent actionEvent)
    {
        Button button = (Button) actionEvent.getSource();

        switch (button.getText())
        {
            case ("Add"):
            {
                if(checkFields())
                {
                    medObservService.saveMedObserv(getFromField());
                    observTable.getItems().add(getFromField());
                    updateList();
                }
                break;
            }
            case("Update"):
            {
               if(observTable.getSelectionModel().getSelectedItem()!=null)
                {
                    MedObserv medObserv = getFromField();
                    medObserv.setId(observTable.getSelectionModel().getSelectedItem().getId());
                    observTable.getItems().set(observTable.getSelectionModel().getSelectedIndex(),medObserv);
                    medObservService.updateMedObserv(medObserv);
                    updateList();
                }
                break;
            }
            case("Delete"):
                {
                    if(observTable.getSelectionModel().getSelectedItem()!=null)
                    {
                         medObservService.deleteMedObserv((int)observTable.getSelectionModel().getSelectedItem().getId());
                         observTable.getItems().remove(observTable.getSelectionModel().getSelectedItem());
                        updateList();
                    }
                    break;
                }
        }
    }


    private MedObserv getFromField()
    {
        MedObserv medObserv = new MedObserv();
        medObserv.setConclusion(conclusionTA.getText());
        medObserv.setDate(Date.valueOf(observDatePicker.getValue()));
        medObserv.setWorker(Main.getLogInWorker());
        medObserv.setPet(petList.getSelectionModel().getSelectedItem());
        return medObserv;
    }

    private Boolean checkFields()
    {
        if(conclusionTA.getText().equals("")|
                observDatePicker.getValue()==null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Unexpected empty field!");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    @FXML
    private  void selectMed()
    {
        if(observTable.getSelectionModel().getSelectedItem()!=null)
        {
            MedObserv medObserv = observTable.getSelectionModel().getSelectedItem();
            observDatePicker.setValue(medObserv.getDate().toLocalDate());
            conclusionTA.setText(medObserv.getConclusion());
            LocalDate last  = medObserv.getDate().toLocalDate();
            LocalDate next = LocalDate.of(last.getYear(),last.getMonth().plus(3),last.getDayOfMonth());
            dateLabel.setText("Next medical observ must been :"+next);

        }
    }

    @FXML
    private void selectPet()
    {
        if(petList.getSelectionModel().getSelectedItem()!=null)
        {
            Pet pet = petList.getSelectionModel().getSelectedItem();
            ObservableList<MedObserv> medObservs= FXCollections.observableArrayList();
            medObservs.addAll(pet.getMedObservList());
            observTable.setItems(medObservs);
        }
    }
    private void updateObservTable()
    {
       if(observTable.getSelectionModel().getSelectedItem()!=null)
       {
           observTable.getItems().clear();
           selectPet();
       }
    }

    private void updateList()
    {
        petList.getItems().clear();
        ObservableList<Pet> pets= FXCollections.observableArrayList();
        pets.addAll(petService.findAllPet());
        petList.setItems(pets);
    }
}
