package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ammach.clientcommandeproduitretrofit.R;

import java.util.List;

import bean.Client;

/**
 * Created by ammach on 10/29/2016.
 */
public class ClientAdapter extends BaseAdapter {

    List<Client> clients;
    Context context;

    public ClientAdapter(List<Client> clients, Context context) {
        this.clients = clients;
        this.context = context;
    }

    @Override
    public int getCount() {
        return clients.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.row_item,null);

        TextView textView= (TextView) convertView.findViewById(R.id.idRow);
        TextView textView1= (TextView) convertView.findViewById(R.id.nomRow);
        TextView textView2= (TextView) convertView.findViewById(R.id.villeRow);

        textView.setText(clients.get(position).getId());
        textView1.setText(clients.get(position).getNom());
        textView2.setText(clients.get(position).getVille());
        return convertView;
    }
}
