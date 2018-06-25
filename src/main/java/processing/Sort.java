package processing;

import model.Piece;

import java.util.ArrayList;

public class Sort {

    public ArrayList bubbleSort (ArrayList<Piece> list) {

        int i, j;
        Piece temp;

        for (i = 0; i < list.size() - 1; i++) {

            for (j = 0; j < list.size() - 1 - i; j++) {

                if (list.get(j).getCoordinates().size() > list.get(j + 1).getCoordinates().size()) {
                    temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1,  temp);
                }
            }
        }
        return list;
    }

}
