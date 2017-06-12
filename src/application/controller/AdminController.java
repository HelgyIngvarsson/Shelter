    package application.controller;

    import application.model.*;
    import application.model.Cell;
    import application.service.*;
    import application.service.impl.*;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.Initializable;
    import javafx.scene.control.*;
    import javafx.scene.control.cell.PropertyValueFactory;
    import javafx.stage.FileChooser;
    import javafx.stage.Stage;

    import java.io.File;
    import java.net.URL;
    import java.sql.Date;
    import java.time.LocalDate;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.ResourceBundle;

    /**
     * Created by ЖЛЗК on 11.06.2017.
     */
    public class AdminController implements Initializable
    {

        private WorkerService workerService = new WorkerServiceImpl();
        private PostService postService = new PostSrviceImpl();
        private PetService petService = new PetServiceImpl();
        private PetTypeService petTypeService = new PetTypeServiceImpl();
        private PetSpecService petSpecService = new PetSpecServiceImpl();
        private CellService cellService = new CellServiceImpl();
        private TypeSpecService typeSpecService = new TypeSpecServiceImpl();
        private RationService rationService = new RationServiceImpl();
        private UserService userService = new UserServiceImpl();


        private List<String> tables = new ArrayList<String>();



        private File exportFile;
        private String table;
        @FXML
        ComboBox<String> tableList;
        @FXML
        TextArea exportTA;

        @FXML
        Label worker_count;

        @FXML
        Label pet_count;
    //    Worker

        @FXML
        private TextField loginField;
        @FXML
        private TextField passField;

        @FXML
        private TextField firstNameField;
        @FXML
        private TextField lastNameField;
        @FXML
        private TextField phoneField;
        @FXML
        private TextField addressField;

        @FXML
        private ComboBox<Post> postComboBox;

        @FXML
        private DatePicker birthdayDatePicker;

        @FXML
        private
        TableView<Worker> workerTable;

        @FXML
        private
        TableColumn idC;
        @FXML
        private
        TableColumn firstNameC;
        @FXML
        private
        TableColumn lastNameC;
        @FXML
        private
        TableColumn postC;
        @FXML
        private
        TableColumn birthdayC;
        @FXML
        private
        TableColumn photoC;
        @FXML
        private
        TableColumn phoneC;
        @FXML
        private
        TableColumn addressC;

    //    Pets
        @FXML
        private TextField nameField;
        @FXML
        private TextField weightField;
        @FXML
        private TextField ageField;

        @FXML
        private ComboBox<PetType> typeComboBox;
        @FXML
        private ComboBox<PetSpec> specComboBox;
        @FXML
        private ComboBox<application.model.Cell> cellComboBox;

        @FXML
        private DatePicker enterDatePicker;

        @FXML
        private
        TableView<Pet> petTable;

        @FXML
        private
        TableColumn petIdC;
        @FXML
        private
        TableColumn nameC;
        @FXML
        private
        TableColumn typeSpecC;
        @FXML
        private
        TableColumn ageC;
        @FXML
        private
        TableColumn weightC;
        @FXML
        private
        TableColumn enterDateC;
        @FXML
        private
        TableColumn cellC;
        @FXML
        private
        TableColumn petPhotoC;

    //Other
        @FXML
        private TextField cellNumberField;
        @FXML
        private ComboBox<Worker> keeperComboBox;

        @FXML
        private
        TableView<application.model.Cell> cellTable;

        @FXML
        private
        TableColumn cellIdTableColumn;
        @FXML
        private
        TableColumn cellTableColumn;
        @FXML
        private
        TableColumn cellKeeperTableColumn;

        @Override
        public void initialize(URL location, ResourceBundle resources) {

            tables.add("worker");
            tables.add("pet");
            tables.add("cell");
            ObservableList observableList = FXCollections.observableArrayList();
            observableList.addAll(tables);
            tableList.setItems(observableList);

    //Worker
            idC.setCellValueFactory(new PropertyValueFactory<Worker, Integer>("id"));
            firstNameC.setCellValueFactory(new PropertyValueFactory<Worker, String>("first_name"));
            lastNameC.setCellValueFactory(new PropertyValueFactory<Worker, String>("last_name"));
            birthdayC.setCellValueFactory(new PropertyValueFactory<Worker, Date>("date_birthday"));
            postC.setCellValueFactory(new PropertyValueFactory<Worker, Post>("post"));
            photoC.setCellValueFactory(new PropertyValueFactory<Worker, String>("photo"));
            phoneC.setCellValueFactory(new PropertyValueFactory<Worker, String>("phone"));
            addressC.setCellValueFactory(new PropertyValueFactory<Worker, String>("address"));

            updateWorkerTable();


    //        Pets
            petIdC.setCellValueFactory(new PropertyValueFactory<Pet, Integer>("id"));
            nameC.setCellValueFactory(new PropertyValueFactory<Pet, String>("name"));
            typeSpecC.setCellValueFactory(new PropertyValueFactory<Pet, TypeSpec>("typeSpec"));
            ageC.setCellValueFactory(new PropertyValueFactory<Pet, Integer>("age"));
            weightC.setCellValueFactory(new PropertyValueFactory<Pet, Double>("weight"));
            enterDateC.setCellValueFactory(new PropertyValueFactory<Pet, Date>("date_enter"));
            cellC.setCellValueFactory(new PropertyValueFactory<Pet, Cell>("cell"));
            petPhotoC.setCellValueFactory(new PropertyValueFactory<Pet, String>("photo"));

            updatePetTable();


    //        Other
            cellIdTableColumn.setCellValueFactory(new PropertyValueFactory<application.model.Cell, Integer>("id"));
            cellTableColumn.setCellValueFactory(new PropertyValueFactory<application.model.Cell, Integer>("cell_number"));
            cellKeeperTableColumn.setCellValueFactory(new PropertyValueFactory<application.model.Cell, Worker>("worker"));

            updateCellTable();


        }

        @FXML
        private void transact(ActionEvent actionEvent)
        {
            Button button = (Button) actionEvent.getSource();
            switch (button.getText())
            {
                case ("Add"):
                    {
                        switch (button.getId()) {
                            case ("workerAdd"): {
                                if (checkWorkerFields()) {
                                    Worker worker = getWorkerFromFields();
                                    workerService.saveWorker(worker);
                                    if(!loginField.equals("")&!passField.equals(""))
                                    {
                                        User user = new User();
                                        user.setLogin(loginField.getText());
                                        user.setPassword(passField.getText());
                                        user.setWorker(worker);
                                        userService.saveUser(user);
                                    }
                                    updateWorkerTable();
                                    updateCellTable();
                                }
                                break;
                            }
                            case("petAdd"):
                                {
                                    if (checkPetFields()) {
                                        Pet pet = getPetFromFields();
                                        typeSpecService.saveTypeSpec(pet.getTypeSpec());
                                        petService.savePet(pet);
                                        updatePetTable();
                                    }
                                    break;
                                }
                            case("cellAdd"):
                            {
                                if (checkCellFields()) {
                                    Cell cell = getCellFromFields();
                                    cellService.saveCell(cell);
                                    updateCellTable();
                                    updatePetTable();
                                }
                                break;
                            }
                        }
                        break;
                    }
                case ("Update"):
                    {
                        switch (button.getId())
                        {
                            case("workerUpdate"):
                                {
                                    if (checkWorkerFields())
                                    {
                                        Worker worker = getWorkerFromFields();
                                        if(workerTable.getSelectionModel().getSelectedItem()!=null)
                                            worker.setId(workerTable.getSelectionModel().getSelectedItem().getId());
                                        workerService.updateWorker(worker);
                                        if(!loginField.equals("")&!passField.equals(""))
                                        {
                                            User user = new User();
                                            user.setLogin(loginField.getText());
                                            user.setPassword(passField.getText());
                                            user.setId(userService.findUser((int)worker.getId()).getId());
                                            user.setWorker(worker);
                                            userService.updateUser(user);
                                        }
                                        updateWorkerTable();
                                        updateCellTable();
                                    }
                                    break;
                                }
                            case ("petUpdate"):
                                {
                                    if (checkPetFields()) {
                                        Pet pet = getPetFromFields();
                                        if(petTable.getSelectionModel().getSelectedItem()!=null)
                                        {
                                            pet.setId(petTable.getSelectionModel().getSelectedItem().getId());
                                            pet.setTypeSpec(petTable.getSelectionModel().getSelectedItem().getTypeSpec());
                                        petService.updatePet(pet);
                                        }
                                        updatePetTable();
                                    }
                                    break;
                                }
                            case("cellUpdate"):
                                {
                                    if (checkCellFields()) {
                                        Cell cell = getCellFromFields();
                                        if(cellTable.getSelectionModel().getSelectedItem()!=null)
                                            cell.setId(cellTable.getSelectionModel().getSelectedItem().getId());
                                        cellService.updateCell(cell);
                                        updateCellTable();
                                        updatePetTable();
                                    }
                                break;
                                }
                        }
                        break;
                    }
                case ("Delete"):
                     {
                         switch (button.getId())
                         {
                             case("workerDelete"):
                                 {
                                     if(workerTable.getSelectionModel().getSelectedItem()!=null)
                                     {
    //                                     userService.deleteUser((int)userService.findUser((int)workerTable.getSelectionModel().getSelectedItem().getId()).getId());
                                         workerService.deleteWorker((int) workerTable.getSelectionModel().getSelectedItem().getId());
                                         updateWorkerTable();
                                         updateCellTable();
                                     }
                                     break;
                                 }
                             case("petDelete"):
                                 {
                                     if(petTable.getSelectionModel().getSelectedItem()!=null)
                                     {
                                       petService.deletePet((int)petTable.getSelectionModel().getSelectedItem().getId());
                                       updatePetTable();
                                     }
                                     break;
                                 }
                                 case("cellDelete"):
                                    {
                                        if (cellTable.getSelectionModel().getSelectedItem()!=null) {
                                         cellService.deleteCell((int) cellTable.getSelectionModel().getSelectedItem().getId());
                                         updatePetTable();
                                         updateCellTable();
                                    }
                                     break;
                             }
                         }
                        break;
                     }
            }
        }

        private Worker getWorkerFromFields()
        {
            Worker worker = new Worker();
                worker.setFirst_name(firstNameField.getText());
                worker.setLast_name(lastNameField.getText());
                worker.setPhone(phoneField.getText());
                worker.setAddress(addressField.getText());
                worker.setDate_birthday(Date.valueOf(birthdayDatePicker.getValue()));
                worker.setPost(postComboBox.getValue());
            return worker;
        }
        private Pet getPetFromFields()
        {
            Pet pet = new Pet();
            pet.setName(nameField.getText());
            pet.setAge(Integer.parseInt(ageField.getText()));
            pet.setWeight(Double.parseDouble(weightField.getText()));
            pet.setDate_enter(Date.valueOf(enterDatePicker.getValue()));
            pet.setCell(cellComboBox.getValue());
            TypeSpec typeSpec = new TypeSpec();
            typeSpec.setPetSpec(specComboBox.getValue());
            typeSpec.setPetType(typeComboBox.getValue());
            pet.setTypeSpec(typeSpec);
            return pet;
        }

        private Cell getCellFromFields()
        {
            Cell cell= new Cell();
            cell.setCell_number(Integer.parseInt(cellNumberField.getText()));
            cell.setWorker(keeperComboBox.getValue());
            return cell;
        }

        private Boolean checkWorkerFields()
        {
            if(firstNameField.getText().equals("")|
                    lastNameField.getText().equals("")|
                    phoneField.getText().equals("")|
                    addressField.getText().equals("")|
                    birthdayDatePicker.getValue()==null|
                    postComboBox.getValue()==null)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Unexpected empty field!");
                alert.showAndWait();
                return false;
            }
                return true;
        }

        private Boolean checkPetFields()
        {
            if(nameField.getText().equals("")|
                    ageField.getText().equals("")|
                    weightField.getText().equals("")|
                    enterDatePicker.getValue()==null|
                    typeComboBox.getValue()==null|
                    specComboBox.getValue()==null|
                    cellComboBox.getValue()==null)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Unexpected empty field!");
                alert.showAndWait();
                return false;
            }
            return true;
        }
        private Boolean checkCellFields()
        {
            if(cellNumberField.getText().equals("")|
                    keeperComboBox.getValue()==null)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Unexpected empty field!");
                alert.showAndWait();
                return false;
            }
            return true;
        }



        private void updateWorkerTable()
        {
            workerTable.getItems().clear();
            ObservableList<Worker> workers = FXCollections.observableArrayList();
            workers.addAll(workerService.findAllWorker());
            workerTable.setItems(workers);
            worker_count.setText(workers.size()+" rows");
            ObservableList<Post> posts = FXCollections.observableArrayList();
            posts.addAll(postService.findAllPost());
            postComboBox.setItems(posts);
        }

        private void updatePetTable()
        {
            petTable.getItems().clear();
            ObservableList<Pet> pets = FXCollections.observableArrayList();
            pets.addAll(petService.findAllPet());
            petTable.setItems(pets);
            pet_count.setText(pets.size()+" rows");
            ObservableList<PetType> types = FXCollections.observableArrayList();
            types.addAll(petTypeService.findAllPetType());
            typeComboBox.setItems(types);

            ObservableList<PetSpec> petSpecs = FXCollections.observableArrayList();
            petSpecs.addAll(petSpecService.findAllPetSpec());
            specComboBox.setItems(petSpecs);

            ObservableList<application.model.Cell> cells = FXCollections.observableArrayList();
            cells.addAll(cellService.findAllCell());
            cellComboBox.setItems(cells);
        }

        private void updateCellTable()
        {
            cellTable.getItems().clear();
            ObservableList<application.model.Cell> cells = FXCollections.observableArrayList();
            cells.addAll(cellService.findAllCell());
            cellTable.setItems(cells);

            ObservableList<Worker> keepers = FXCollections.observableArrayList();
            keepers.addAll(workerService.findAllKeepers());
            keeperComboBox.setItems(keepers);
        }

        @FXML
        void selectWorker()
        {
            Worker worker = workerTable.getSelectionModel().getSelectedItem();
            if(worker!=null)
            {
                firstNameField.setText(worker.getFirst_name());
                lastNameField.setText(worker.getLast_name());
                phoneField.setText(worker.getPhone());
                addressField.setText(worker.getAddress());
                birthdayDatePicker.setValue(worker.getDate_birthday().toLocalDate());
                postComboBox.setValue(worker.getPost());

                if(userService.findUser((int)workerTable.getSelectionModel().getSelectedItem().getId())!=null){
                    User user= userService.findUser((int)workerTable.getSelectionModel().getSelectedItem().getId());
                    loginField.setText(user.getLogin());
                    passField.setText(user.getPassword());
                }

            }
        }

        @FXML
        void selectPet()
        {
            Pet pet = petTable.getSelectionModel().getSelectedItem();
            if(pet!=null)
            {
                nameField.setText(pet.getName());
                ageField.setText(String.valueOf(pet.getAge()));
                typeComboBox.setValue(pet.getTypeSpec().getPetType());
                specComboBox.setValue(pet.getTypeSpec().getPetSpec());
                weightField.setText(String.valueOf(pet.getWeight()));
                enterDatePicker.setValue(pet.getDate_enter().toLocalDate());
                cellComboBox.setValue(pet.getCell());
            }
        }

        @FXML
        void selectCell()
        {
            Cell cell = cellTable.getSelectionModel().getSelectedItem();
            if(cell!=null)
            {
                cellNumberField.setText(String.valueOf(cell.getCell_number()));
                keeperComboBox.setValue(cell.getWorker());
            }
        }

        @FXML
        private  void chooseFile()
        {
            FileChooser fileChooser = new FileChooser();

            //Set extension filter
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel sheet", "*.cvs");
            fileChooser.getExtensionFilters().add(extFilter);

            //Show save file dialog
            File file = fileChooser.showSaveDialog(new Stage());

            if(file != null){
                exportFile= file;
                exportTA.setText(exportTA.getText()+"Save into "+exportFile.getAbsolutePath()+"\n");
            }
        }

        @FXML
        private void cancelExport()
        {
            exportTA.setText("");
        }

        @FXML
        private void export()
        {
            exportService export = new exportService();
            export.executeExport(exportFile,table);
        }

        @FXML
        private void selectTable()
        {
            if(tableList.getSelectionModel().getSelectedItem()!=null)
            {
                table = tableList.getSelectionModel().getSelectedItem();
            exportTA.setText(exportTA.getText()+"Export table "+table+"\n");
            }
        }
    }
