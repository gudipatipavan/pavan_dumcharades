package com.dumexample.dumcharades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

public class Dumcharades3 extends ExpandableListActivity {
   Button start;
	@SuppressWarnings("unchecked")
	public void onCreate(Bundle savedInstanceState) {
    	try{
    		 super.onCreate(savedInstanceState);
    		 setContentView(R.layout.main);
    		 start=(Button)findViewById(R.id.button1);
        
        SimpleExpandableListAdapter expListAdapter =
			new SimpleExpandableListAdapter(
					this,
					createGroupList(), 				// Creating group List.
					R.layout.group_row,				// Group item layout XML.			
					new String[] { "TEAM NAME" },	// the key of group item.
					new int[] { R.id.row_name },	// ID of each group item.-Data under the key goes into this TextView.					
					createChildList(),				// childData describes second-level entries.
					R.layout.child_row,				// Layout for sub-level entries(second level).
					new String[] {"PLAYER NAME"},		// Keys in childData maps to display.
					new int[] { R.id.grp_child}		// Data under the keys above go into these TextViews.
				);
			setListAdapter( expListAdapter );		// setting the adapter in the list.
			
    	}catch(Exception e){
    		System.out.println("Errrr +++ " + e.getMessage());
    	}
    }
    
	/* Creating the Hashmap for the row */
	@SuppressWarnings("unchecked")
	private List createGroupList() {
	  	  ArrayList result = new ArrayList();
	  	  for( int i = 1 ; i < 3 ; ++i ) { // 2 groups........1
	  		HashMap m = new HashMap();
	  	    m.put( "TEAM NAME","TEAM NAME " + i ); // the key and it's value.
	  		result.add( m );
	  	  }
	  	  return (List)result;
    }
    
	/* creatin the HashMap for the children */
    @SuppressWarnings("unchecked")
	private List createChildList() {
    	  
    	ArrayList result = new ArrayList();
    	for( int i = 0 ; i < 2 ; ++i ) { // this -15 is the number of groups(Here it's fifteen)
    	  /* each group need each HashMap-Here for each group we have 3 subgroups */
    	  final ArrayList secList = new ArrayList(); 
    	  for( int n = 1 ; n < 10 ; n++ ) {
    	    HashMap child = new HashMap();
    		child.put( "PLAYER NAME", "PLAYER NAME " + n );    	    
    		secList.add( child );
    	  }
    	 result.add( secList );
    	 start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent Intent=new Intent(Dumcharades3.this,Dumcharades4.class);
				startActivity(Intent);
				
				
			}
		});
    	}    	 
    	return result;
    }
    public void  onContentChanged  () {
    	System.out.println("onContentChanged");
	    super.onContentChanged();	      
    }
    /* This function is called on each child click */
    public boolean onChildClick( ExpandableListView parent, View v, int groupPosition,int childPosition,long id) {
    	System.out.println("Inside onChildClick at groupPosition = " + groupPosition +" Child clicked at position " + childPosition);
    	return true;
    }

    /* This function is called on expansion of the group */
    public void  onGroupExpand  (int groupPosition) {
    	try{
    		 System.out.println("Group exapanding Listener => groupPosition = " + groupPosition);
    	}catch(Exception e){
    		System.out.println(" groupPosition Errrr +++ " + e.getMessage());
    	}
    }  
}