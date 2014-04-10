package com.tradedoubler.billing.service.ax.webservice.call;

import com.microsoft.schemas.dynamics._2006._02.documents.entitykey.*;
import com.microsoft.schemas.dynamics._2006._02.documents.entitykeylist.EntityKeyList;
import com.microsoft.schemas.dynamics._2006._02.documents.querycriteria.*;

import java.util.*;

/** Utility methods for Ax web service calls */
class CallUtil {

    /** Create entity key list for Delete, Update and Read calls */
    public static EntityKeyList createEntityKeyListForOneItem(String field, String value) {
        HashMap<String, String> fieldAndValueMap = new HashMap<String, String>();
        fieldAndValueMap.put(field, value);

        return CallUtil.createEntityKeyList(fieldAndValueMap);
    }

    /** Create entity key list for Delete, Update and Read calls */
    public static EntityKeyList createEntityKeyList(Map<String, String> fieldAndValueMap) {
        Set<String> fields = fieldAndValueMap.keySet();
        KeyData keyData = new KeyData();

        for (String field : fields) {
            KeyField keyField = new KeyField();
            keyField.setField(field);
            keyField.setValue(fieldAndValueMap.get(field));
            keyData.getKeyField().add(keyField);
        }

        EntityKey entityKey = new EntityKey();
        entityKey.setKeyData(keyData);

        EntityKeyList entityKeyList = new EntityKeyList();
        entityKeyList.getEntityKey().add(entityKey);
        return entityKeyList;
    }

    /** Create query criteria for Find calls */
    public static QueryCriteria createQueryCriteria(String dataSourceName, String fieldName, String value,
                                                    CriteriaElement... additionalElements) {
        QueryCriteria criteria = new QueryCriteria();
        CriteriaElement criteriaElement = createCriteriaElement(dataSourceName, fieldName, value);
        List<CriteriaElement> criteriaElementList = criteria.getCriteriaElement();
        criteriaElementList.add(criteriaElement);
        for (CriteriaElement additionalElement : additionalElements) {
            criteriaElementList.add(additionalElement);
        }
        return criteria;
    }

    /** Create query criteria for Find calls */
    public static CriteriaElement createCriteriaElement(String dataSourceName, String fieldName, String value) {
        CriteriaElement criteriaElement = new CriteriaElement();
        criteriaElement.setDataSourceName(dataSourceName);
        criteriaElement.setFieldName(fieldName);
        criteriaElement.setOperator(Operator.EQUAL);
        criteriaElement.setValue1(value);
        return criteriaElement;
    }

}