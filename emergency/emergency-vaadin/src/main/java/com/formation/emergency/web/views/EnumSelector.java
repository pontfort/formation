package com.formation.emergency.web.views;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import com.vaadin.data.Container;
import com.vaadin.data.util.IndexedContainer;

public class EnumSelector {
    private static String CAPTION_PROPERTY_NAME = "caption";

	public static Container createContainerFromEnumClass(
            Class<? extends Enum<?>> enumClass) {
        LinkedHashMap<Enum<?>, String> enumMap = new LinkedHashMap<Enum<?>, String>();
        for (Object enumConstant : enumClass.getEnumConstants()) {
            enumMap.put((Enum<?>) enumConstant, enumConstant.toString());
        }

        return createContainerFromMap(enumMap);
    }
    private static Container createContainerFromMap(Map<?, String> hashMap) {
        IndexedContainer container = new IndexedContainer();
        container.addContainerProperty(CAPTION_PROPERTY_NAME, String.class, "");

        Iterator<?> iter = hashMap.keySet().iterator();
        while (iter.hasNext()) {
            Object itemId = iter.next();
            container.addItem(itemId);
            container.getItem(itemId).getItemProperty(CAPTION_PROPERTY_NAME)
                    .setValue(hashMap.get(itemId));
        }

        return container;
    }
}