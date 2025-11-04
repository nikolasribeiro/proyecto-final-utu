package ventanas;

import com.mycompany.proyectofinalprogramacion.encuentro.Encuentro;
import com.mycompany.proyectofinalprogramacion.encuentro.EncuentroDAO;
import equipos.Equipo;
import equipos.EquiposDAO;
import java.awt.Color;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import pronostica.PronosticaDAO;
import pronostica.PronosticaDetallado;
import pronostica.PronosticoDetalladoDAO;
import usuarios.Rol;
import usuarios.User;
import usuarios.UserDAO;

/**
 *
 * @author Leo
 */
public class PanelAdm extends javax.swing.JFrame {

    private DefaultListModel<String> userListModel = new DefaultListModel<>();
    private DefaultListModel<String> teamListModel = new DefaultListModel<>();
    private DefaultListModel<String> eventListModel = new DefaultListModel<>();
    private DefaultListModel<String> betListModel = new DefaultListModel<>();
    private User userLoggedIn;

    /**
     * Creates new form PanelAdm
     */
    public PanelAdm() {
        initComponents();
        loadData();
    }
    
    public PanelAdm(User userLoggedIn) {
        initComponents();
        loadData();

        this.userLoggedIn = userLoggedIn;
    }

    public void setUsersIntoUsersListModel() {
        userListModel.clear();

        UserDAO userDao = new UserDAO();
        List<User> users = userDao.getAll();
        userList.setModel(userListModel);

        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getRole() == Rol.user) {
                String element = "Nombre: " + users.get(i).getName() + " - Correo: " + users.get(i).getEmail() + " - Estado: " + users.get(i).getState();
                userListModel.addElement(element);
            }
        }
    }

    public void setTeamsIntoTeamListModel() {
        teamListModel.clear();
        EquiposDAO equipoDao = new EquiposDAO();
        List<Equipo> equipos = equipoDao.obtenerTodosLosEquipos();
        teamList.setModel(teamListModel);

        for (int i = 0; i < equipos.size(); i++) {
            String element = "ID: " + equipos.get(i).getIdEquipo() + " - Nombre: " + equipos.get(i).getNombre();
            teamListModel.addElement(element);
        }
    }

    public void setEventsIntoEventListModel() {
        eventListModel.clear();
        EncuentroDAO encuentroDao = new EncuentroDAO();
        List<Encuentro> encuentros = encuentroDao.listar();
        eventList.setModel(eventListModel);

        for (int i = 0; i < encuentros.size(); i++) {
            String element = (i + 1) + ") " + "Local: " + encuentros.get(i).getNombreLocal() + " - Visitante: " + encuentros.get(i).getNombreVisita() + " - Estado del encuentro: " + encuentros.get(i).getEstado();
            eventListModel.addElement(element);
        }
    }

    public void setBetsIntoBetListModel() {
        betListModel.clear();
        PronosticoDetalladoDAO pronosticaDetalladoDao = new PronosticoDetalladoDAO();
        List<PronosticaDetallado> pronosticos = pronosticaDetalladoDao.listarTotalDePronosticosConDatosAdicionales();
        betList.setModel(betListModel);
        EncuentroDAO encuentroDao = new EncuentroDAO();

        for (int i = 0; i < pronosticos.size(); i++) {
            String element
                    = "Partido: "
                    + pronosticos.get(i).getNombreLocal()
                    + " vs "
                    + pronosticos.get(i).getNombreVisita()
                    + " // "
                    + " Usuario: "
                    + pronosticos.get(i).getNombreUsuario()
                    + " (Local: "
                    + pronosticos.get(i).getPrediccionLocal()
                    + " Visita: "
                    + pronosticos.get(i).getPrediccionVisita()
                    + ")";

            Encuentro encuentro = encuentroDao.traerEncuentro(pronosticos.get(i).getEncuentroId());

            if (encuentro.getEstado().equals("finalizado")) {
                element
                        = element
                        + " // Resultado del encuentro "
                        + "Local: "
                        + pronosticos.get(i).getResultadoRealLocal()
                        + " - Visita: "
                        + pronosticos.get(i).getResultadoRealVisita();
            }

            betListModel.addElement(element);
        }
    }

    private void loadData() {
        setUsersIntoUsersListModel();
        setTeamsIntoTeamListModel();
        setEventsIntoEventListModel();
        setBetsIntoBetListModel();

        startEventBtn.setEnabled(false);
        deleteEventBtn.setEnabled(false);

        eventList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                _eventListValueChanged(evt);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList<>();
        addUserBtn = new javax.swing.JButton();
        editUserBtn = new javax.swing.JButton();
        deleteUserBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        teamList = new javax.swing.JList<>();
        addTeamBtn = new javax.swing.JButton();
        editTeamBtn = new javax.swing.JButton();
        deleteTeamBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        betList = new javax.swing.JList<>();
        addBetBtn = new javax.swing.JButton();
        editBetBtn = new javax.swing.JButton();
        deleteBetBtn = new javax.swing.JButton();
        refreshListBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        eventList = new javax.swing.JList<>();
        addEventBtn = new javax.swing.JButton();
        startEventBtn = new javax.swing.JButton();
        deleteEventBtn = new javax.swing.JButton();
        btnAdminExit = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Panel de Administrador");

        userList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(userList);

        addUserBtn.setText("Agregar");
        addUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserBtnActionPerformed(evt);
            }
        });

        editUserBtn.setText("Editar");
        editUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserBtnActionPerformed(evt);
            }
        });

        deleteUserBtn.setText("Eliminar");
        deleteUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(addUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addUserBtn)
                    .addComponent(editUserBtn)
                    .addComponent(deleteUserBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Usuarios", jPanel1);

        teamList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(teamList);

        addTeamBtn.setText("Agregar");
        addTeamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeamBtnActionPerformed(evt);
            }
        });

        editTeamBtn.setText("Editar");
        editTeamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTeamBtnActionPerformed(evt);
            }
        });

        deleteTeamBtn.setText("Eliminar");
        deleteTeamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTeamBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(addTeamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editTeamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteTeamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTeamBtn)
                    .addComponent(editTeamBtn)
                    .addComponent(deleteTeamBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Equipos", jPanel2);

        betList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(betList);

        addBetBtn.setText("Agregar");

        editBetBtn.setText("Editar");

        deleteBetBtn.setText("Eliminar");

        refreshListBtn.setText("Refrescar lista");
        refreshListBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshListBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(addBetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editBetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteBetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(refreshListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBetBtn)
                    .addComponent(editBetBtn)
                    .addComponent(deleteBetBtn)
                    .addComponent(refreshListBtn))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Pronosticos", jPanel3);

        eventList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(eventList);

        addEventBtn.setText("Agregar");
        addEventBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEventBtnActionPerformed(evt);
            }
        });

        startEventBtn.setBackground(new java.awt.Color(51, 153, 0));
        startEventBtn.setText("Comenzar Encuentro");
        startEventBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startEventBtnActionPerformed(evt);
            }
        });

        deleteEventBtn.setText("Eliminar");
        deleteEventBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEventBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(addEventBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(startEventBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteEventBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEventBtn)
                    .addComponent(startEventBtn)
                    .addComponent(deleteEventBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Encuentros", jPanel4);

        btnAdminExit.setText("Salir");
        btnAdminExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminExitActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar Sesion");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(188, 188, 188)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdminExit, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnCerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdminExit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _eventListValueChanged(ListSelectionEvent evt) {
        int eventSelectedIndex = eventList.getSelectedIndex();
        if (eventSelectedIndex == -1) {
            return;
        }

        EncuentroDAO encuentroDao = new EncuentroDAO();
        List<Encuentro> events = encuentroDao.listar();
        Encuentro eventSelected = events.get(eventSelectedIndex);
        startEventBtn.setEnabled(true);

        if (eventSelected.getEstado().equals("habilitado")) {
            startEventBtn.setText("Comenzar Evento");
            startEventBtn.setBackground(Color.GREEN);
            startEventBtn.setEnabled(true);
            deleteEventBtn.setEnabled(false);
        }

        if (eventSelected.getEstado().equals("jugando")) {
            startEventBtn.setText("Finalizar Evento");
            startEventBtn.setBackground(Color.red);
            startEventBtn.setEnabled(true);
            deleteEventBtn.setEnabled(false);
        }

        if (eventSelected.getEstado().equals("finalizado")) {
            startEventBtn.setText("Finalizar Evento");
            startEventBtn.setEnabled(false);
            deleteEventBtn.setEnabled(true);
        }

    }


    private void btnAdminExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnAdminExitActionPerformed

    private void addUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserBtnActionPerformed
        NewUser newUserWindow = new NewUser(this);
        newUserWindow.setVisible(true);
    }//GEN-LAST:event_addUserBtnActionPerformed

    private void deleteUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserBtnActionPerformed
        UserDAO userDao = new UserDAO();
        List<User> users = userDao.getAll();
        int encuentroSelectedIndex = userList.getSelectedIndex();
        User userSelected = users.get(encuentroSelectedIndex);
        int userConfirmation = JOptionPane.showConfirmDialog(rootPane, "Estas seguro que queres eliminar a " + userSelected.getName() + "?", "Confirmar", JOptionPane.INFORMATION_MESSAGE);

        if (userConfirmation == 0) {
            userDao.delete(userSelected.getLogin());
            setUsersIntoUsersListModel();
            return;
        }
    }//GEN-LAST:event_deleteUserBtnActionPerformed

    private void editUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserBtnActionPerformed
        UserDAO userDao = new UserDAO();
        List<User> users = userDao.getAll();
        int encuentroSelectedIndex = userList.getSelectedIndex();
        User userSelected = users.get(encuentroSelectedIndex);

        NewUser newUserWindow = new NewUser(this, userSelected);
        newUserWindow.setVisible(true);
    }//GEN-LAST:event_editUserBtnActionPerformed

    private void addTeamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeamBtnActionPerformed
        NewTeam newTeamWindow = new NewTeam(this);
        newTeamWindow.setVisible(true);
    }//GEN-LAST:event_addTeamBtnActionPerformed

    private void editTeamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTeamBtnActionPerformed
        EquiposDAO equipoDao = new EquiposDAO();
        List<Equipo> equipos = equipoDao.obtenerTodosLosEquipos();
        int equipoSelectedIndex = teamList.getSelectedIndex();

        System.out.println("Index seleccionado: " + equipoSelectedIndex);

        Equipo teamSelected = equipos.get(equipoSelectedIndex);

        System.out.println("Equipo Seleccionado: " + teamSelected.getNombre());

        NewTeam newTeamWindow = new NewTeam(teamSelected, this);
        newTeamWindow.setVisible(true);
    }//GEN-LAST:event_editTeamBtnActionPerformed

    private void deleteTeamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTeamBtnActionPerformed
        EquiposDAO equipoDao = new EquiposDAO();
        List<Equipo> equipos = equipoDao.obtenerTodosLosEquipos();
        int equipoSelectedIndex = teamList.getSelectedIndex();
        Equipo teamSelected = equipos.get(equipoSelectedIndex);
        int userConfirmation = JOptionPane.showConfirmDialog(rootPane, "Estas seguro que queres eliminar a " + teamSelected.getNombre() + "?", "Confirmar", JOptionPane.INFORMATION_MESSAGE);

        if (userConfirmation == 0) {
            equipoDao.eliminarEquipo(teamSelected.getIdEquipo());
            setTeamsIntoTeamListModel();
            return;
        }
    }//GEN-LAST:event_deleteTeamBtnActionPerformed

    private void addEventBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEventBtnActionPerformed
        NewEvent newEventWindow = new NewEvent(this);
        newEventWindow.setVisible(true);
    }//GEN-LAST:event_addEventBtnActionPerformed

    private void deleteEventBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEventBtnActionPerformed
        int eventSelectedIndex = eventList.getSelectedIndex();
        EncuentroDAO encuentroDao = new EncuentroDAO();
        PronosticaDAO pronosticaDao = new PronosticaDAO();

        List<Encuentro> events = encuentroDao.listar();
        Encuentro eventSelected = events.get(eventSelectedIndex);

        if (eventSelected.getEstado().equals("finalizado")) {
            int userConfirmation = JOptionPane.showConfirmDialog(
                    this,
                    "Estas seguro que queres eliminar el evento: " + eventSelected.getFecha(),
                    "Confirmar",
                    JOptionPane.WARNING_MESSAGE
            );

            if (userConfirmation == 0) {
                pronosticaDao.delete(eventSelected.getIdEncuentro());
                encuentroDao.borrarEncuentro(eventSelected.getIdEncuentro());
                JOptionPane.showMessageDialog(
                        this,
                        "Evento eliminado correctamente",
                        "Exito",
                        JOptionPane.INFORMATION_MESSAGE
                );

                setEventsIntoEventListModel();
                return;
            }
        }

        JOptionPane.showMessageDialog(
                this,
                "El evento no puede ser eliminado hasta que finalice",
                "Error!",
                JOptionPane.ERROR_MESSAGE
        );
        return;


    }//GEN-LAST:event_deleteEventBtnActionPerformed

    private void startEventBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startEventBtnActionPerformed
        int eventSelectedIndex = eventList.getSelectedIndex();
        EncuentroDAO encuentroDao = new EncuentroDAO();

        List<Encuentro> events = encuentroDao.listar();
        Encuentro eventSelected = events.get(eventSelectedIndex);

        if (eventSelected.getEstado().equals("habilitado")) {
            eventSelected.setEstado("jugando");
            encuentroDao.actualizarEncuentro(eventSelected);
            setEventsIntoEventListModel();

            JOptionPane.showMessageDialog(rootPane, "Evento actualizado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (eventSelected.getEstado().equals("jugando")) {
            // Esta logica es unicamente para eventos que tengan
            // el estado de jugando
            // A partir de aca, los goles se setean automaticamente y
            // se aplica la logica de el añadido de los puntos
            int totalGoalsToLocal = ThreadLocalRandom.current().nextInt(6);
            int totalGoalsToVisit = ThreadLocalRandom.current().nextInt(6);

            eventSelected.setEstado("finalizado");
            eventSelected.setResultadoLocal(totalGoalsToLocal);
            eventSelected.setResultadoVisita(totalGoalsToVisit);
            encuentroDao.actualizarEncuentro(eventSelected);
            setEventsIntoEventListModel();

            PronosticoDetalladoDAO pronosticaDetalladoDao = new PronosticoDetalladoDAO();
            UserDAO userDao = new UserDAO();
            List<PronosticaDetallado> pronosticos = pronosticaDetalladoDao.listarTotalDePronosticosConDatosAdicionales();

            // Inicio de logica de puntos
            for (PronosticaDetallado pronostico : pronosticos) {
                // 0. Declaramos una variable en la que se tomaran el total de puntos
                int points = 0;
                // 1. Traemos el usuario que hizo un pronostico
                User user = userDao.get(pronostico.getLogin());

                // 2. Verificamos el pronostico que hizo el usuario
                int userLocalBet = pronostico.getPrediccionLocal();
                int userVisitBet = pronostico.getPrediccionVisita();

                // 3. Validamos a ver si efectivamente el usuario acerto en su prediccion
                // acerto a que ganaba el local?
                if (userLocalBet > pronostico.getResultadoRealVisita()) {
                    points += 1;
                }

                // acerto a que ganaba el visitante?
                if (userVisitBet > pronostico.getResultadoRealLocal()) {
                    points += 1;
                }

                // acerto a que ganaba el local Y ADEMAS el resultado exacto?
                if (userLocalBet > pronostico.getResultadoRealVisita() && userLocalBet == totalGoalsToLocal) {
                    points += 5;
                }

                // acerto a que ganaba la visita Y ADEMAS el resultado exacto?
                if (userVisitBet > pronostico.getResultadoRealLocal() && userVisitBet == totalGoalsToVisit) {
                    points += 5;
                }

                // 4. Actualizamos los puntos totales del usuario
                points = points + user.getPoints();
                user.setPoints(points);

                userDao.update(user);
            }

            JOptionPane.showMessageDialog(rootPane, "Evento actualizado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
            return;
        }


    }//GEN-LAST:event_startEventBtnActionPerformed

    private void refreshListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshListBtnActionPerformed
        setBetsIntoBetListModel();
    }//GEN-LAST:event_refreshListBtnActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
         // confirmar eleccion
       int confirm = JOptionPane.showConfirmDialog(this, "Estas seguro capo?", "Cerrar Sesion", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION){
            // cierra ventana actual
            this.dispose();
            
            // abre la ventana login devuelta
            Login login = new Login();
            login.setVisible(true);
        }
    }//GEN-LAST:event_btnCerrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PanelAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelAdm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBetBtn;
    private javax.swing.JButton addEventBtn;
    private javax.swing.JButton addTeamBtn;
    private javax.swing.JButton addUserBtn;
    private javax.swing.JList<String> betList;
    private javax.swing.JButton btnAdminExit;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton deleteBetBtn;
    private javax.swing.JButton deleteEventBtn;
    private javax.swing.JButton deleteTeamBtn;
    private javax.swing.JButton deleteUserBtn;
    private javax.swing.JButton editBetBtn;
    private javax.swing.JButton editTeamBtn;
    private javax.swing.JButton editUserBtn;
    private javax.swing.JList<String> eventList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton refreshListBtn;
    private javax.swing.JButton startEventBtn;
    private javax.swing.JList<String> teamList;
    private javax.swing.JList<String> userList;
    // End of variables declaration//GEN-END:variables
}
