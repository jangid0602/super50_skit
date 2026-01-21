import java.util.ArrayList;
import java.util.List;

public class checkPageNumbers{
    public List<String> missedPages(int[] pagesRead, int totalPages){
        List<String> pagesList = new ArrayList<>();
        if (pagesRead.length == 0) {
            pagesList.add("1-" + String.valueOf(totalPages));
            return pagesList;
        }

        for (int pageIndex = 1; pageIndex < pagesRead.length; pageIndex++){
            if (pagesRead[pageIndex] - pagesRead[pageIndex - 1] > 1){
                pagesList.add(String.valueOf(pagesRead[pageIndex - 1] + 1) + "-" + String.valueOf(pagesRead[pageIndex] - 1));
            }
        }
        if (pagesRead[pagesRead.length - 1] < totalPages){
            pagesList.add(String.valueOf(pagesRead[pagesRead.length - 1] + 1) + "-" + String.valueOf(totalPages));
        }
        return pagesList;
        
    }
}