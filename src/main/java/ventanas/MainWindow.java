package ventanas;

import com.mycompany.proyectofinalprogramacion.encuentro.Encuentro;
import com.mycompany.proyectofinalprogramacion.encuentro.EncuentroDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import pronostica.Pronostica;
import pronostica.PronosticaDAO;
import pronostica.PronosticaDetallado;
import pronostica.PronosticoDetalladoDAO;
import usuarios.User;
import usuarios.UserDAO;

/**
 *
 * @author Nicolas Ribeiro
 */
public class MainWindow extends javax.swing.JFrame {

    private DefaultListModel<String> eventListModel = new DefaultListModel<>();
    private DefaultListModel<String> rankingListModel = new DefaultListModel<>();
    private DefaultListModel<String> betsListModel = new DefaultListModel<>();
    private EncuentroDAO encuentroDao = new EncuentroDAO();
    private UserDAO userDao = new UserDAO();
    private PronosticoDetalladoDAO pronosticoDetalladoDao = new PronosticoDetalladoDAO();
    private PronosticaDAO pronosticaDao = new PronosticaDAO();

    private User userLoggedIn;

    public MainWindow(User userLoggedIn) {
        initComponents();
        this.userLoggedIn = userLoggedIn;
        _initialState();
        refreshRankingList();
        refreshBetsList();

        lblPoints.setText("Puntos: " + String.valueOf(userLoggedIn.getPoints()));

        eventList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                _eventListValueChanged(evt);
            }
        });
    }

    private List<Encuentro> obtenerEncuentros() {
        List<Encuentro> tempEventList = encuentroDao.listar();
        List<Encuentro> encuentroList = new ArrayList<Encuentro>();

        for (Encuentro tempEvent : tempEventList) {
            if (tempEvent.getEstado().equals("habilitado")) {
                encuentroList.add(tempEvent);
            }
        }

        return encuentroList;
    }

    private void _eventListValueChanged(ListSelectionEvent evt) {
        localFieldGoals.setValue(0);
        visitFieldGoals.setValue(0);
        List<Encuentro> encuentroList = obtenerEncuentros();

        int encuentroSelectedIndex = eventList.getSelectedIndex();

        if (encuentroSelectedIndex < 0) {
            return;
        }

        eventPanel.setVisible(true);
        System.out.println("Indice seleccionado: " + encuentroSelectedIndex);
        Encuentro encuentroSelected = encuentroList.get(encuentroSelectedIndex);

        eventTitle.setText("Encuentro: " + (encuentroSelectedIndex + 1));
        localTeamName.setText(encuentroSelected.getNombreLocal());
        visitTeamName.setText(encuentroSelected.getNombreVisita());
        eventIdFromLabel.setText(Integer.toString(encuentroSelected.getIdEncuentro()));
    }

    public void refreshMatchList() {
        System.out.println("Estamos dentro de refreschMatchList");
        eventListModel.clear();
        List<Encuentro> encuentroList = obtenerEncuentros();

        System.out.println("Filtrado de lista terminado");
        for (int i = 0; i < encuentroList.size(); i++) {
            Encuentro encuentro = encuentroList.get(i);
            Pronostica pronosticoExistente = pronosticaDao.getByLoginAndIdEncuentro(
                    userLoggedIn.getLogin(),
                    encuentro.getIdEncuentro()
            );
            
            if (pronosticoExistente == null) {
                // Si el usuario aun NO ha realizado ningun pronostico para el encuentro
                // iterado, entonces debemos mostrar ese encuentro para pronosticar
                System.out.println("Iniciando loop de eventos ya filtrados");
                String element = (i + 1) + ") " + "Local: " + encuentroList.get(i).getNombreLocal() + " - Visitante: " + encuentroList.get(i).getNombreVisita();
                System.out.println("Seteo de eventos");
                eventListModel.addElement(element);
                System.out.println("Elemento añadido correctamente...");
            }

        }
    }

    public void refreshRankingList() {
        rankingListModel.clear();
        List<String> rankings = userDao.getRankingSorted();

        for (String ranking : rankings) {
            rankingListModel.addElement(ranking);
        }
    }

    public void refreshBetsList() {
        betsListModel.clear();
        List<PronosticaDetallado> pronosticos = pronosticoDetalladoDao.listarTotalDePronosticosConDatosAdicionalesPorUsuario(userLoggedIn);

        for (PronosticaDetallado pronostico : pronosticos) {
            String element
                    = "Partido: "
                    + pronostico.getNombreLocal()
                    + " vs "
                    + pronostico.getNombreVisita()
                    + " || Local: "
                    + pronostico.getPrediccionLocal()
                    + " Visita: "
                    + pronostico.getPrediccionVisita()
                    + "";

            Encuentro encuentro = encuentroDao.traerEncuentro(pronostico.getEncuentroId());

            if (encuentro.getEstado().equals("finalizado")) {
                element
                        = element
                        + " || Resultado del encuentro "
                        + "Local: "
                        + pronostico.getResultadoRealLocal()
                        + " - Visita: "
                        + pronostico.getResultadoRealVisita();
            }

            betsListModel.addElement(element);
        }
    }

    public void _initialState() {
        eventPanel.setVisible(false);
        eventIdFromLabel.setVisible(false);
        eventList.setModel(eventListModel);
        rankingList.setModel(rankingListModel);
        betsRealizedList.setModel(betsListModel);
        refreshMatchList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        lblPoints = new javax.swing.JLabel();
        eventPanel = new javax.swing.JPanel();
        eventTitle = new javax.swing.JLabel();
        localTeamName = new javax.swing.JLabel();
        visitTeamName = new javax.swing.JLabel();
        addBet = new javax.swing.JButton();
        lblVersus = new javax.swing.JLabel();
        eventIdFromLabel = new javax.swing.JLabel();
        localFieldGoals = new javax.swing.JSpinner();
        visitFieldGoals = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        profileBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rankingList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        betsRealizedList = new javax.swing.JList<>();
        btncerrar = new javax.swing.JButton();
        refreshMatchBets = new javax.swing.JButton();
        refreshListsBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Tabla de Partidos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 367, -1));

        eventList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Encuentro 1:  Barcelona - Madrid", "Encuentro 2:  Peñarol - Nacional", "Encuentro 3:  Argentina - Mexico", "Encuentro 4:  Alemania - Brasil" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(eventList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 66, 367, 120));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 1040, 10));

        lblPoints.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblPoints.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPoints.setText("Puntos: 0");
        getContentPane().add(lblPoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 120, 42));

        eventPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        eventPanel.setMinimumSize(new java.awt.Dimension(374, 175));

        eventTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        eventTitle.setText("Encuentro 1");

        localTeamName.setText("Barcelona");

        visitTeamName.setText("Madrid");

        addBet.setBackground(new java.awt.Color(0, 102, 204));
        addBet.setText("Añadir Pronostico");
        addBet.setOpaque(true);
        addBet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBetActionPerformed(evt);
            }
        });

        lblVersus.setText("VS");

        eventIdFromLabel.setText("jLabel4");

        localFieldGoals.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999, 1));

        visitFieldGoals.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999, 1));

        javax.swing.GroupLayout eventPanelLayout = new javax.swing.GroupLayout(eventPanel);
        eventPanel.setLayout(eventPanelLayout);
        eventPanelLayout.setHorizontalGroup(
            eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addBet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(eventPanelLayout.createSequentialGroup()
                        .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(localTeamName)
                            .addGroup(eventPanelLayout.createSequentialGroup()
                                .addComponent(localFieldGoals, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addComponent(lblVersus)))
                        .addGap(12, 12, 12)
                        .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(visitTeamName)
                            .addComponent(visitFieldGoals, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(eventPanelLayout.createSequentialGroup()
                        .addComponent(eventTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eventIdFromLabel)))
                .addContainerGap())
        );
        eventPanelLayout.setVerticalGroup(
            eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventTitle)
                    .addComponent(eventIdFromLabel))
                .addGap(44, 44, 44)
                .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(localTeamName)
                    .addComponent(visitTeamName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVersus)
                    .addComponent(localFieldGoals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(visitFieldGoals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(addBet, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(eventPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 6, 400, 210));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 10, 220));

        profileBtn.setText("Perfil");
        profileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileBtnActionPerformed(evt);
            }
        });
        getContentPane().add(profileBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 150, 230, 60));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 10, 350));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 6, 10, 220));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel6.setText("Ranking total");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel7.setText("Pronosticos Realizados");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        rankingList.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rankingList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(rankingList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 470, 310));

        betsRealizedList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(betsRealizedList);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 510, 310));

        btncerrar.setText("Cerrar sesion");
        btncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btncerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, -1, -1));

        refreshMatchBets.setText("Refrescar lista de Partidos");
        refreshMatchBets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshMatchBetsActionPerformed(evt);
            }
        });
        getContentPane().add(refreshMatchBets, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 360, -1));

        refreshListsBtn.setText("Actualizar listas");
        refreshListsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshListsBtnActionPerformed(evt);
            }
        });
        getContentPane().add(refreshListsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 1040, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBetActionPerformed
        String userLogin = userLoggedIn.getLogin();
        int localInputValue = (int) localFieldGoals.getValue();
        int visitInputValue = (int) visitFieldGoals.getValue();
        String eventId = eventIdFromLabel.getText();

        Pronostica pronostico = new Pronostica(userLogin, Integer.parseInt(eventId), localInputValue, visitInputValue);
        PronosticaDAO pronosticaDao = new PronosticaDAO();
        pronosticaDao.create(pronostico);
        eventPanel.setVisible(false);

        refreshBetsList();
        refreshMatchList();
        JOptionPane.showMessageDialog(eventPanel, "Pronostico añadido correctamente!");
    }//GEN-LAST:event_addBetActionPerformed

    private void btncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarActionPerformed
        // confirmar eleccion
        int confirm = JOptionPane.showConfirmDialog(this, "Estas seguro capo?", "Cerrar Sesion", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // cierra ventana actual
            this.dispose();

            // abre la ventana login devuelta
            Login login = new Login();
            login.setVisible(true);
        }
    }//GEN-LAST:event_btncerrarActionPerformed

    private void refreshMatchBetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshMatchBetsActionPerformed
        System.out.println("Accion de refresco triggereada");
        refreshMatchList();
    }//GEN-LAST:event_refreshMatchBetsActionPerformed

    private void profileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileBtnActionPerformed
        User currentUserLoggedIn = userDao.get(this.userLoggedIn.getLogin());
        ProfileWindow profileWindow = new ProfileWindow(currentUserLoggedIn, this);
        profileWindow.setVisible(true);
    }//GEN-LAST:event_profileBtnActionPerformed

    private void refreshListsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshListsBtnActionPerformed
        refreshBetsList();
        refreshRankingList();
        refreshMatchList();
        eventPanel.setVisible(false);
        User userLoggedIn = userDao.get(this.userLoggedIn.getLogin());
        this.userLoggedIn = userLoggedIn;
        lblPoints.setText("Puntos: " + String.valueOf(this.userLoggedIn.getPoints()));
    }//GEN-LAST:event_refreshListsBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBet;
    private javax.swing.JList<String> betsRealizedList;
    private javax.swing.JButton btncerrar;
    private javax.swing.JLabel eventIdFromLabel;
    private javax.swing.JList<String> eventList;
    private javax.swing.JPanel eventPanel;
    private javax.swing.JLabel eventTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblPoints;
    private javax.swing.JLabel lblVersus;
    private javax.swing.JSpinner localFieldGoals;
    private javax.swing.JLabel localTeamName;
    private javax.swing.JButton profileBtn;
    private javax.swing.JList<String> rankingList;
    private javax.swing.JButton refreshListsBtn;
    private javax.swing.JButton refreshMatchBets;
    private javax.swing.JSpinner visitFieldGoals;
    private javax.swing.JLabel visitTeamName;
    // End of variables declaration//GEN-END:variables
}
