import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.WindowListener;

/******************************************************************************
 *  Name:    Aditya Pillai
 *  Date:    31 May 2017
 *
 *  Description:    Form files for Swing-based application. Looks ugly,
 *                  though. I don't know GUIs.
 *
 *  Copyright 2017 Aditya Pillai
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a
 *  copy of this software and associated documentation files (the "Software"),
 *  to deal in the Software without restriction, including without limitation
 *  the rights to use, copy, modify, merge, publish, distribute, sublicense,
 *  and/or sell copies of the Software, and to permit persons to whom the
 *  Software is furnished to do so, subject to the following conditions:
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 *  FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 *  IN THE SOFTWARE.
 ******************************************************************************/
class ConnectFourGUI {
    private JFrame finalFrame;

    private JPanel mainPanel = new JPanel();
    private JPanel boardPanel = new JPanel();
    private JButton button1 = new JButton();
    private JButton button2 = new JButton();
    private JButton button3 = new JButton();
    private JButton button4 = new JButton();
    private JButton button5 = new JButton();
    private JButton button6 = new JButton();
    private JButton button7 = new JButton();
    private JLabel textPane1 = new JLabel();
    private JPanel textPanel = new JPanel();
    private JTable table1;

    @SuppressWarnings("unused")
    private WindowListener exitListener;
    private Board myBoard;

    private String messagePrompt = "Go";

    ConnectFourGUI(){
        myBoard = new Board();

        finalFrame = new JFrame();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        button1.setText("Column 1");
        button2.setText("Column 2");
        button3.setText("Column 3");
        button4.setText("Column 4");
        button5.setText("Column 5");
        button6.setText("Column 6");
        button7.setText("Column 7");

        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.X_AXIS));
        textPane1.setText(messagePrompt);
        textPanel.add(textPane1);

        mainPanel.add(textPanel);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(button1); buttonPanel.add(button2); buttonPanel.add(button3); buttonPanel.add(button4);
        buttonPanel.add(button5); buttonPanel.add(button6); buttonPanel.add(button7);

        mainPanel.add(buttonPanel);

        boardPanel.setLayout(new BoxLayout(boardPanel, BoxLayout.LINE_AXIS));

        String[] names = {"1", "2", "3", "4", "5", "6", "7"};
        table1 = new JTable(myBoard.getGridBoard(), names) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                Component comp = super.prepareRenderer(renderer, row, col);
                String value = getModel().getValueAt(row, col).toString();
                if (value.equalsIgnoreCase("R")) {
                    comp.setBackground(Color.RED);
                }
                else if (value.equalsIgnoreCase("Y")) {
                    comp.setBackground(Color.YELLOW);
                }
                else if (value.equalsIgnoreCase("O")) {
                    comp.setBackground(Color.WHITE);
                }
                return comp;
            }
        };
        table1.setPreferredSize(new Dimension(700, 500));
        table1.setRowHeight(500/6);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table1.setDefaultRenderer(String.class, centerRenderer);
        boardPanel.add(table1);

        mainPanel.add(boardPanel);


        finalFrame.add(mainPanel);
        finalFrame.pack();
        finalFrame.addWindowListener(exitListener);
        finalFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        finalFrame.setVisible(true);

        System.out.println("Listening.");


        this.button1.addActionListener(e -> {
            myBoard.takeTurn(0);
            updateBoard();
            System.out.println(myBoard);

        });
        this.button2.addActionListener(e -> {
            myBoard.takeTurn(1);
            updateBoard();
            System.out.println(myBoard);

        });
        this.button3.addActionListener(e -> {
            myBoard.takeTurn(2);
            System.out.println(myBoard);
            updateBoard();
        });
        this.button4.addActionListener(e -> {
            myBoard.takeTurn(3);
            System.out.println(myBoard);
            updateBoard();
        });
        this.button5.addActionListener(e -> {
            myBoard.takeTurn(4);
            System.out.println(myBoard);
            updateBoard();
        });
        this.button6.addActionListener(e -> {
            myBoard.takeTurn(5);
            System.out.println(myBoard);
            updateBoard();
        });
        this.button7.addActionListener(e -> {
            myBoard.takeTurn(6);
            System.out.println(myBoard);
            updateBoard();
        });

    }

    private void updateBoard() {
        messagePrompt = "It is " + myBoard.playerTurn + "'s turn.";
        if (myBoard.checkWin()) {
            if (myBoard.playerTurn == 'Y') {
                messagePrompt = "Red has won.";
            } else messagePrompt = "Yellow has won.";
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);

        }
        System.out.println(messagePrompt);
        textPanel.remove(textPane1);
        textPane1.setText(messagePrompt);
        textPanel.add(textPane1);
        textPane1.repaint();
        textPanel.repaint();
        table1.repaint();
        boardPanel.repaint();
        mainPanel.repaint();
        finalFrame.repaint();
        finalFrame.pack();
    }



}
