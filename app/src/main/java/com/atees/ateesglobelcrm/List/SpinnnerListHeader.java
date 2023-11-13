package com.atees.ateesglobelcrm.List;

import com.atees.ateesglobelcrm.Models.spinnerModel;
import com.atees.ateesglobelcrm.Models.spinnerheaderModel;
import com.atees.ateesglobelcrm.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnnerListHeader {

   public static List<spinnerheaderModel> getSpinnerheaderList() {
      List<spinnerheaderModel> spinnerheaderList = new ArrayList<>();
      spinnerheaderModel Normal = new spinnerheaderModel();
      Normal.setHeadername("Normal");
      spinnerheaderList.add(Normal);

      spinnerheaderModel Code = new spinnerheaderModel();
      Code.setHeadername("Code");
      spinnerheaderList.add(Code);

      spinnerheaderModel Header1 = new spinnerheaderModel();
      Header1.setHeadername("Header1");
      spinnerheaderList.add(Header1);

      spinnerheaderModel Header2 = new spinnerheaderModel();
      Header2.setHeadername("Header2");
      spinnerheaderList.add(Header2);

      spinnerheaderModel Header3 = new spinnerheaderModel();
      Header3.setHeadername("Header3");
      spinnerheaderList.add(Header3);

      spinnerheaderModel Header4 = new spinnerheaderModel();
      Header4.setHeadername("Header4");
      spinnerheaderList.add(Header4);

      return spinnerheaderList;
   }
}
