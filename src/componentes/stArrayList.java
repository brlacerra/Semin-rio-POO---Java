package src.componentes;


import java.util.ArrayList;

public class stArrayList<E> extends ArrayList<E>{
    public interface ListChangeListener{
        void onListChanged();
    }

    private ListChangeListener listener;

    public void setListChangeListener(ListChangeListener listener){
        this.listener = listener;
    }

    @Override
    public boolean add(E e) {
        boolean result = super.add(e);
        if (listener != null) {
            listener.onListChanged();
        }
        return result;
    }

    @Override
    public boolean remove(Object o) {
        boolean result = super.remove(o);
        if (listener != null) {
            listener.onListChanged();
        }
        return result;
    }

    @Override
    public void clear() {
        super.clear();
        if (listener != null) {
            listener.onListChanged();
        }
    }

}
