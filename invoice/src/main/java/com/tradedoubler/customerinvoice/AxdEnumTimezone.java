//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.28 at 01:35:45 PM CET 
//


package com.tradedoubler.customerinvoice;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_Timezone.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_Timezone">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GMTMINUS1200INTERNATIONALDATELINEWEST"/>
 *     &lt;enumeration value="GMTMINUS1100MIDWAYISLAND_SAMOA"/>
 *     &lt;enumeration value="GMTMINUS1000HAWAII"/>
 *     &lt;enumeration value="GMTMINUS0900ALASKA"/>
 *     &lt;enumeration value="GMTMINUS0800PACIFICTIME"/>
 *     &lt;enumeration value="GMTMINUS0800TIJUANA_BAJACALIFORNIA"/>
 *     &lt;enumeration value="GMTMINUS0700ARIZONA"/>
 *     &lt;enumeration value="GMTMINUS0700MOUNTAINTIME"/>
 *     &lt;enumeration value="GMTMINUS0700CHIHUAHUA_LAPAZ_MAZATLAN"/>
 *     &lt;enumeration value="GMTMINUS0600CENTRALAMERICA"/>
 *     &lt;enumeration value="GMTMINUS0600CENTRALTIME"/>
 *     &lt;enumeration value="GMTMINUS0600GUADALAJARA_MEXICOCITY"/>
 *     &lt;enumeration value="GMTMINUS0600SASKATCHEWAN"/>
 *     &lt;enumeration value="GMTMINUS0500BOGOTA_LIMA_QUITO_RIOBRANCO"/>
 *     &lt;enumeration value="GMTMINUS0500EASTERNTIME"/>
 *     &lt;enumeration value="GMTMINUS0500INDIANA"/>
 *     &lt;enumeration value="GMTMINUS0400ATLANTICTIME"/>
 *     &lt;enumeration value="GMTMINUS0400LAPAZ"/>
 *     &lt;enumeration value="GMTMINUS0400MANAUS"/>
 *     &lt;enumeration value="GMTMINUS0400SANTIAGO"/>
 *     &lt;enumeration value="GMTMINUS0430CARACAS"/>
 *     &lt;enumeration value="GMTMINUS0330NEWFOUNDLAND"/>
 *     &lt;enumeration value="GMTMINUS0300BRASILIA"/>
 *     &lt;enumeration value="GMTMINUS0300BUENOSAIRES_GEORGETOWN"/>
 *     &lt;enumeration value="GMTMINUS0300GREENLAND"/>
 *     &lt;enumeration value="GMTMINUS0300MONTEVIDEO"/>
 *     &lt;enumeration value="GMTMINUS0200MIDATLANTIC"/>
 *     &lt;enumeration value="GMTMINUS0100AZORES"/>
 *     &lt;enumeration value="GMTMINUS0100CAPEVERDIS"/>
 *     &lt;enumeration value="GMT_CASABLANCA_MONTROVIA_REYKJAVIK"/>
 *     &lt;enumeration value="GMT_DUBLIN_EDINBURGH_LISBON_LONDON"/>
 *     &lt;enumeration value="GMTPLUS0100_AMSTERDAM_BERLIN_BERN_ROME"/>
 *     &lt;enumeration value="GMTPLUS0100BELGRADE_BRATISLAVA_BUDAPEST"/>
 *     &lt;enumeration value="GMTPLUS0100BRUSSELS_COPENHAGEN_MADRID"/>
 *     &lt;enumeration value="GMTPLUS0100SARAJEVO_SKOPJE_WARSAW_ZAGREB"/>
 *     &lt;enumeration value="GMTPLUS0100WESTCENTRALAFRICA"/>
 *     &lt;enumeration value="GMTPLUS0200AMMAN"/>
 *     &lt;enumeration value="GMTPLUS0200ATHENS_BUCHAREST_ISTANBUL"/>
 *     &lt;enumeration value="GMTPLUS0200BEIRUT"/>
 *     &lt;enumeration value="GMTPLUS0200MINSK"/>
 *     &lt;enumeration value="GMTPLUS0200CAIRO"/>
 *     &lt;enumeration value="GMTPLUS0200HARARE_PRETORIA"/>
 *     &lt;enumeration value="GMTPLUS0200HELSINKI_KYIV_RIGA_VILNIUS"/>
 *     &lt;enumeration value="GMTPLUS0200JERUSALEM"/>
 *     &lt;enumeration value="GMTPLUS0200WINDHOEK"/>
 *     &lt;enumeration value="GMTPLUS0300BAGHDAD"/>
 *     &lt;enumeration value="GMTPLUS0300KUWAIT_RIYADH"/>
 *     &lt;enumeration value="GMTPLUS0300MOSCOW_STPETERSBURG_VOLGOGRAD"/>
 *     &lt;enumeration value="GMTPLUS0300NAIROBI"/>
 *     &lt;enumeration value="GMTPLUS0300TBILISI"/>
 *     &lt;enumeration value="GMTPLUS0330TEHRAN"/>
 *     &lt;enumeration value="GMTPLUS0400ABUDHABI_MUSCAT"/>
 *     &lt;enumeration value="GMTPLUS0400BAKU"/>
 *     &lt;enumeration value="GMTPLUS0400CAUCASUSSTANDARDTIME"/>
 *     &lt;enumeration value="GMTPLUS0400YEREVAN"/>
 *     &lt;enumeration value="GMTPLUS0430KABUL"/>
 *     &lt;enumeration value="GMTPLUS0500EKATERINBURG"/>
 *     &lt;enumeration value="GMTPLUS0500ISLAMABAD_KARACHI_TASHKENT"/>
 *     &lt;enumeration value="GMTPLUS0530CHENNAI_KOLKATA_MUMBAI"/>
 *     &lt;enumeration value="GMTPLUS0530SRIJAYAWARDENEPURA"/>
 *     &lt;enumeration value="GMTPLUS0545KATHMANDU"/>
 *     &lt;enumeration value="GMTPLUS0600ALMATY_NOVOSIBIRSK"/>
 *     &lt;enumeration value="GMTPLUS0600ASTANA_DHAKA"/>
 *     &lt;enumeration value="GMTPLUS0630_YANGON"/>
 *     &lt;enumeration value="GMTPLUS0700_BANGKOK_HANOI_JAKARTA"/>
 *     &lt;enumeration value="GMTPLUS0700KRASNOYARSK"/>
 *     &lt;enumeration value="GMTPLUS0800BEIJING_CHONGQING_HONGKONG"/>
 *     &lt;enumeration value="GMTPLUS0800IRKUTSK_ULAANBATAAR"/>
 *     &lt;enumeration value="GMTPLUS0800KUALALUMPUR_SINGAPORE"/>
 *     &lt;enumeration value="GMTPLUS0800PERTH"/>
 *     &lt;enumeration value="GMTPLUS0800TAIPEI"/>
 *     &lt;enumeration value="GMTPLUS0900OSAKA_SAPPORO_TOKYO"/>
 *     &lt;enumeration value="GMTPLUS0900SEOUL"/>
 *     &lt;enumeration value="GMTPLUS0900YAKUTSK"/>
 *     &lt;enumeration value="GMTPLUS0930ADELAIDE"/>
 *     &lt;enumeration value="GMTPLUS0930DARWIN"/>
 *     &lt;enumeration value="GMTPLUS1000BRISBANE"/>
 *     &lt;enumeration value="GMTPLUS1000CANBERRA_MELBOURNE_SYDNEY"/>
 *     &lt;enumeration value="GMTPLUS1000GUAM_PORTMORESBY"/>
 *     &lt;enumeration value="GMTPLUS1000HOBART"/>
 *     &lt;enumeration value="GMTPLUS1000VLADIVOSTOK"/>
 *     &lt;enumeration value="GMTPLUS1100MAGADAN_SOLOMONIS"/>
 *     &lt;enumeration value="GMTPLUS1200AUCKLAND_WELLINGTON"/>
 *     &lt;enumeration value="GMTPLUS1200FIJI_KAMCHATKA_MARSHALLIS"/>
 *     &lt;enumeration value="GMTPLUS1300NUKU_ALOFA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_Timezone")
@XmlEnum
public enum AxdEnumTimezone {

    @XmlEnumValue("GMTMINUS1200INTERNATIONALDATELINEWEST")
    GMTMINUS_1200_INTERNATIONALDATELINEWEST("GMTMINUS1200INTERNATIONALDATELINEWEST"),
    @XmlEnumValue("GMTMINUS1100MIDWAYISLAND_SAMOA")
    GMTMINUS_1100_MIDWAYISLAND_SAMOA("GMTMINUS1100MIDWAYISLAND_SAMOA"),
    @XmlEnumValue("GMTMINUS1000HAWAII")
    GMTMINUS_1000_HAWAII("GMTMINUS1000HAWAII"),
    @XmlEnumValue("GMTMINUS0900ALASKA")
    GMTMINUS_0900_ALASKA("GMTMINUS0900ALASKA"),
    @XmlEnumValue("GMTMINUS0800PACIFICTIME")
    GMTMINUS_0800_PACIFICTIME("GMTMINUS0800PACIFICTIME"),
    @XmlEnumValue("GMTMINUS0800TIJUANA_BAJACALIFORNIA")
    GMTMINUS_0800_TIJUANA_BAJACALIFORNIA("GMTMINUS0800TIJUANA_BAJACALIFORNIA"),
    @XmlEnumValue("GMTMINUS0700ARIZONA")
    GMTMINUS_0700_ARIZONA("GMTMINUS0700ARIZONA"),
    @XmlEnumValue("GMTMINUS0700MOUNTAINTIME")
    GMTMINUS_0700_MOUNTAINTIME("GMTMINUS0700MOUNTAINTIME"),
    @XmlEnumValue("GMTMINUS0700CHIHUAHUA_LAPAZ_MAZATLAN")
    GMTMINUS_0700_CHIHUAHUA_LAPAZ_MAZATLAN("GMTMINUS0700CHIHUAHUA_LAPAZ_MAZATLAN"),
    @XmlEnumValue("GMTMINUS0600CENTRALAMERICA")
    GMTMINUS_0600_CENTRALAMERICA("GMTMINUS0600CENTRALAMERICA"),
    @XmlEnumValue("GMTMINUS0600CENTRALTIME")
    GMTMINUS_0600_CENTRALTIME("GMTMINUS0600CENTRALTIME"),
    @XmlEnumValue("GMTMINUS0600GUADALAJARA_MEXICOCITY")
    GMTMINUS_0600_GUADALAJARA_MEXICOCITY("GMTMINUS0600GUADALAJARA_MEXICOCITY"),
    @XmlEnumValue("GMTMINUS0600SASKATCHEWAN")
    GMTMINUS_0600_SASKATCHEWAN("GMTMINUS0600SASKATCHEWAN"),
    @XmlEnumValue("GMTMINUS0500BOGOTA_LIMA_QUITO_RIOBRANCO")
    GMTMINUS_0500_BOGOTA_LIMA_QUITO_RIOBRANCO("GMTMINUS0500BOGOTA_LIMA_QUITO_RIOBRANCO"),
    @XmlEnumValue("GMTMINUS0500EASTERNTIME")
    GMTMINUS_0500_EASTERNTIME("GMTMINUS0500EASTERNTIME"),
    @XmlEnumValue("GMTMINUS0500INDIANA")
    GMTMINUS_0500_INDIANA("GMTMINUS0500INDIANA"),
    @XmlEnumValue("GMTMINUS0400ATLANTICTIME")
    GMTMINUS_0400_ATLANTICTIME("GMTMINUS0400ATLANTICTIME"),
    @XmlEnumValue("GMTMINUS0400LAPAZ")
    GMTMINUS_0400_LAPAZ("GMTMINUS0400LAPAZ"),
    @XmlEnumValue("GMTMINUS0400MANAUS")
    GMTMINUS_0400_MANAUS("GMTMINUS0400MANAUS"),
    @XmlEnumValue("GMTMINUS0400SANTIAGO")
    GMTMINUS_0400_SANTIAGO("GMTMINUS0400SANTIAGO"),
    @XmlEnumValue("GMTMINUS0430CARACAS")
    GMTMINUS_0430_CARACAS("GMTMINUS0430CARACAS"),
    @XmlEnumValue("GMTMINUS0330NEWFOUNDLAND")
    GMTMINUS_0330_NEWFOUNDLAND("GMTMINUS0330NEWFOUNDLAND"),
    @XmlEnumValue("GMTMINUS0300BRASILIA")
    GMTMINUS_0300_BRASILIA("GMTMINUS0300BRASILIA"),
    @XmlEnumValue("GMTMINUS0300BUENOSAIRES_GEORGETOWN")
    GMTMINUS_0300_BUENOSAIRES_GEORGETOWN("GMTMINUS0300BUENOSAIRES_GEORGETOWN"),
    @XmlEnumValue("GMTMINUS0300GREENLAND")
    GMTMINUS_0300_GREENLAND("GMTMINUS0300GREENLAND"),
    @XmlEnumValue("GMTMINUS0300MONTEVIDEO")
    GMTMINUS_0300_MONTEVIDEO("GMTMINUS0300MONTEVIDEO"),
    @XmlEnumValue("GMTMINUS0200MIDATLANTIC")
    GMTMINUS_0200_MIDATLANTIC("GMTMINUS0200MIDATLANTIC"),
    @XmlEnumValue("GMTMINUS0100AZORES")
    GMTMINUS_0100_AZORES("GMTMINUS0100AZORES"),
    @XmlEnumValue("GMTMINUS0100CAPEVERDIS")
    GMTMINUS_0100_CAPEVERDIS("GMTMINUS0100CAPEVERDIS"),
    GMT_CASABLANCA_MONTROVIA_REYKJAVIK("GMT_CASABLANCA_MONTROVIA_REYKJAVIK"),
    GMT_DUBLIN_EDINBURGH_LISBON_LONDON("GMT_DUBLIN_EDINBURGH_LISBON_LONDON"),
    @XmlEnumValue("GMTPLUS0100_AMSTERDAM_BERLIN_BERN_ROME")
    GMTPLUS_0100_AMSTERDAM_BERLIN_BERN_ROME("GMTPLUS0100_AMSTERDAM_BERLIN_BERN_ROME"),
    @XmlEnumValue("GMTPLUS0100BELGRADE_BRATISLAVA_BUDAPEST")
    GMTPLUS_0100_BELGRADE_BRATISLAVA_BUDAPEST("GMTPLUS0100BELGRADE_BRATISLAVA_BUDAPEST"),
    @XmlEnumValue("GMTPLUS0100BRUSSELS_COPENHAGEN_MADRID")
    GMTPLUS_0100_BRUSSELS_COPENHAGEN_MADRID("GMTPLUS0100BRUSSELS_COPENHAGEN_MADRID"),
    @XmlEnumValue("GMTPLUS0100SARAJEVO_SKOPJE_WARSAW_ZAGREB")
    GMTPLUS_0100_SARAJEVO_SKOPJE_WARSAW_ZAGREB("GMTPLUS0100SARAJEVO_SKOPJE_WARSAW_ZAGREB"),
    @XmlEnumValue("GMTPLUS0100WESTCENTRALAFRICA")
    GMTPLUS_0100_WESTCENTRALAFRICA("GMTPLUS0100WESTCENTRALAFRICA"),
    @XmlEnumValue("GMTPLUS0200AMMAN")
    GMTPLUS_0200_AMMAN("GMTPLUS0200AMMAN"),
    @XmlEnumValue("GMTPLUS0200ATHENS_BUCHAREST_ISTANBUL")
    GMTPLUS_0200_ATHENS_BUCHAREST_ISTANBUL("GMTPLUS0200ATHENS_BUCHAREST_ISTANBUL"),
    @XmlEnumValue("GMTPLUS0200BEIRUT")
    GMTPLUS_0200_BEIRUT("GMTPLUS0200BEIRUT"),
    @XmlEnumValue("GMTPLUS0200MINSK")
    GMTPLUS_0200_MINSK("GMTPLUS0200MINSK"),
    @XmlEnumValue("GMTPLUS0200CAIRO")
    GMTPLUS_0200_CAIRO("GMTPLUS0200CAIRO"),
    @XmlEnumValue("GMTPLUS0200HARARE_PRETORIA")
    GMTPLUS_0200_HARARE_PRETORIA("GMTPLUS0200HARARE_PRETORIA"),
    @XmlEnumValue("GMTPLUS0200HELSINKI_KYIV_RIGA_VILNIUS")
    GMTPLUS_0200_HELSINKI_KYIV_RIGA_VILNIUS("GMTPLUS0200HELSINKI_KYIV_RIGA_VILNIUS"),
    @XmlEnumValue("GMTPLUS0200JERUSALEM")
    GMTPLUS_0200_JERUSALEM("GMTPLUS0200JERUSALEM"),
    @XmlEnumValue("GMTPLUS0200WINDHOEK")
    GMTPLUS_0200_WINDHOEK("GMTPLUS0200WINDHOEK"),
    @XmlEnumValue("GMTPLUS0300BAGHDAD")
    GMTPLUS_0300_BAGHDAD("GMTPLUS0300BAGHDAD"),
    @XmlEnumValue("GMTPLUS0300KUWAIT_RIYADH")
    GMTPLUS_0300_KUWAIT_RIYADH("GMTPLUS0300KUWAIT_RIYADH"),
    @XmlEnumValue("GMTPLUS0300MOSCOW_STPETERSBURG_VOLGOGRAD")
    GMTPLUS_0300_MOSCOW_STPETERSBURG_VOLGOGRAD("GMTPLUS0300MOSCOW_STPETERSBURG_VOLGOGRAD"),
    @XmlEnumValue("GMTPLUS0300NAIROBI")
    GMTPLUS_0300_NAIROBI("GMTPLUS0300NAIROBI"),
    @XmlEnumValue("GMTPLUS0300TBILISI")
    GMTPLUS_0300_TBILISI("GMTPLUS0300TBILISI"),
    @XmlEnumValue("GMTPLUS0330TEHRAN")
    GMTPLUS_0330_TEHRAN("GMTPLUS0330TEHRAN"),
    @XmlEnumValue("GMTPLUS0400ABUDHABI_MUSCAT")
    GMTPLUS_0400_ABUDHABI_MUSCAT("GMTPLUS0400ABUDHABI_MUSCAT"),
    @XmlEnumValue("GMTPLUS0400BAKU")
    GMTPLUS_0400_BAKU("GMTPLUS0400BAKU"),
    @XmlEnumValue("GMTPLUS0400CAUCASUSSTANDARDTIME")
    GMTPLUS_0400_CAUCASUSSTANDARDTIME("GMTPLUS0400CAUCASUSSTANDARDTIME"),
    @XmlEnumValue("GMTPLUS0400YEREVAN")
    GMTPLUS_0400_YEREVAN("GMTPLUS0400YEREVAN"),
    @XmlEnumValue("GMTPLUS0430KABUL")
    GMTPLUS_0430_KABUL("GMTPLUS0430KABUL"),
    @XmlEnumValue("GMTPLUS0500EKATERINBURG")
    GMTPLUS_0500_EKATERINBURG("GMTPLUS0500EKATERINBURG"),
    @XmlEnumValue("GMTPLUS0500ISLAMABAD_KARACHI_TASHKENT")
    GMTPLUS_0500_ISLAMABAD_KARACHI_TASHKENT("GMTPLUS0500ISLAMABAD_KARACHI_TASHKENT"),
    @XmlEnumValue("GMTPLUS0530CHENNAI_KOLKATA_MUMBAI")
    GMTPLUS_0530_CHENNAI_KOLKATA_MUMBAI("GMTPLUS0530CHENNAI_KOLKATA_MUMBAI"),
    @XmlEnumValue("GMTPLUS0530SRIJAYAWARDENEPURA")
    GMTPLUS_0530_SRIJAYAWARDENEPURA("GMTPLUS0530SRIJAYAWARDENEPURA"),
    @XmlEnumValue("GMTPLUS0545KATHMANDU")
    GMTPLUS_0545_KATHMANDU("GMTPLUS0545KATHMANDU"),
    @XmlEnumValue("GMTPLUS0600ALMATY_NOVOSIBIRSK")
    GMTPLUS_0600_ALMATY_NOVOSIBIRSK("GMTPLUS0600ALMATY_NOVOSIBIRSK"),
    @XmlEnumValue("GMTPLUS0600ASTANA_DHAKA")
    GMTPLUS_0600_ASTANA_DHAKA("GMTPLUS0600ASTANA_DHAKA"),
    @XmlEnumValue("GMTPLUS0630_YANGON")
    GMTPLUS_0630_YANGON("GMTPLUS0630_YANGON"),
    @XmlEnumValue("GMTPLUS0700_BANGKOK_HANOI_JAKARTA")
    GMTPLUS_0700_BANGKOK_HANOI_JAKARTA("GMTPLUS0700_BANGKOK_HANOI_JAKARTA"),
    @XmlEnumValue("GMTPLUS0700KRASNOYARSK")
    GMTPLUS_0700_KRASNOYARSK("GMTPLUS0700KRASNOYARSK"),
    @XmlEnumValue("GMTPLUS0800BEIJING_CHONGQING_HONGKONG")
    GMTPLUS_0800_BEIJING_CHONGQING_HONGKONG("GMTPLUS0800BEIJING_CHONGQING_HONGKONG"),
    @XmlEnumValue("GMTPLUS0800IRKUTSK_ULAANBATAAR")
    GMTPLUS_0800_IRKUTSK_ULAANBATAAR("GMTPLUS0800IRKUTSK_ULAANBATAAR"),
    @XmlEnumValue("GMTPLUS0800KUALALUMPUR_SINGAPORE")
    GMTPLUS_0800_KUALALUMPUR_SINGAPORE("GMTPLUS0800KUALALUMPUR_SINGAPORE"),
    @XmlEnumValue("GMTPLUS0800PERTH")
    GMTPLUS_0800_PERTH("GMTPLUS0800PERTH"),
    @XmlEnumValue("GMTPLUS0800TAIPEI")
    GMTPLUS_0800_TAIPEI("GMTPLUS0800TAIPEI"),
    @XmlEnumValue("GMTPLUS0900OSAKA_SAPPORO_TOKYO")
    GMTPLUS_0900_OSAKA_SAPPORO_TOKYO("GMTPLUS0900OSAKA_SAPPORO_TOKYO"),
    @XmlEnumValue("GMTPLUS0900SEOUL")
    GMTPLUS_0900_SEOUL("GMTPLUS0900SEOUL"),
    @XmlEnumValue("GMTPLUS0900YAKUTSK")
    GMTPLUS_0900_YAKUTSK("GMTPLUS0900YAKUTSK"),
    @XmlEnumValue("GMTPLUS0930ADELAIDE")
    GMTPLUS_0930_ADELAIDE("GMTPLUS0930ADELAIDE"),
    @XmlEnumValue("GMTPLUS0930DARWIN")
    GMTPLUS_0930_DARWIN("GMTPLUS0930DARWIN"),
    @XmlEnumValue("GMTPLUS1000BRISBANE")
    GMTPLUS_1000_BRISBANE("GMTPLUS1000BRISBANE"),
    @XmlEnumValue("GMTPLUS1000CANBERRA_MELBOURNE_SYDNEY")
    GMTPLUS_1000_CANBERRA_MELBOURNE_SYDNEY("GMTPLUS1000CANBERRA_MELBOURNE_SYDNEY"),
    @XmlEnumValue("GMTPLUS1000GUAM_PORTMORESBY")
    GMTPLUS_1000_GUAM_PORTMORESBY("GMTPLUS1000GUAM_PORTMORESBY"),
    @XmlEnumValue("GMTPLUS1000HOBART")
    GMTPLUS_1000_HOBART("GMTPLUS1000HOBART"),
    @XmlEnumValue("GMTPLUS1000VLADIVOSTOK")
    GMTPLUS_1000_VLADIVOSTOK("GMTPLUS1000VLADIVOSTOK"),
    @XmlEnumValue("GMTPLUS1100MAGADAN_SOLOMONIS")
    GMTPLUS_1100_MAGADAN_SOLOMONIS("GMTPLUS1100MAGADAN_SOLOMONIS"),
    @XmlEnumValue("GMTPLUS1200AUCKLAND_WELLINGTON")
    GMTPLUS_1200_AUCKLAND_WELLINGTON("GMTPLUS1200AUCKLAND_WELLINGTON"),
    @XmlEnumValue("GMTPLUS1200FIJI_KAMCHATKA_MARSHALLIS")
    GMTPLUS_1200_FIJI_KAMCHATKA_MARSHALLIS("GMTPLUS1200FIJI_KAMCHATKA_MARSHALLIS"),
    @XmlEnumValue("GMTPLUS1300NUKU_ALOFA")
    GMTPLUS_1300_NUKU_ALOFA("GMTPLUS1300NUKU_ALOFA");
    private final String value;

    AxdEnumTimezone(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTimezone fromValue(String v) {
        for (AxdEnumTimezone c: AxdEnumTimezone.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
