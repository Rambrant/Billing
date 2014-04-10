
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_TrvHotelChargeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_TrvHotelChargeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DailyRoomRate"/>
 *     &lt;enumeration value="TelephoneCharge"/>
 *     &lt;enumeration value="RestaurantCharge"/>
 *     &lt;enumeration value="RoomServiceCharge"/>
 *     &lt;enumeration value="MinibarCharge"/>
 *     &lt;enumeration value="LoungebarCharge"/>
 *     &lt;enumeration value="GiftshopCharge"/>
 *     &lt;enumeration value="LaundryCharge"/>
 *     &lt;enumeration value="ValetCharge"/>
 *     &lt;enumeration value="MovieCharge"/>
 *     &lt;enumeration value="BusinessCenterCharge"/>
 *     &lt;enumeration value="HealthClubCharge"/>
 *     &lt;enumeration value="TransportationCharge"/>
 *     &lt;enumeration value="ConferenceRoomCharge"/>
 *     &lt;enumeration value="BanquetCharge"/>
 *     &lt;enumeration value="InternetAccessCharge"/>
 *     &lt;enumeration value="RoomTaxCharge"/>
 *     &lt;enumeration value="NonRoomTaxCharge"/>
 *     &lt;enumeration value="GratuityCharge"/>
 *     &lt;enumeration value="Gift"/>
 *     &lt;enumeration value="BusinessEntertainment"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="HotelDepositAmount"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_TrvHotelChargeType")
@XmlEnum
public enum AxdEnumTrvHotelChargeType {

    @XmlEnumValue("DailyRoomRate")
    DAILY_ROOM_RATE("DailyRoomRate"),
    @XmlEnumValue("TelephoneCharge")
    TELEPHONE_CHARGE("TelephoneCharge"),
    @XmlEnumValue("RestaurantCharge")
    RESTAURANT_CHARGE("RestaurantCharge"),
    @XmlEnumValue("RoomServiceCharge")
    ROOM_SERVICE_CHARGE("RoomServiceCharge"),
    @XmlEnumValue("MinibarCharge")
    MINIBAR_CHARGE("MinibarCharge"),
    @XmlEnumValue("LoungebarCharge")
    LOUNGEBAR_CHARGE("LoungebarCharge"),
    @XmlEnumValue("GiftshopCharge")
    GIFTSHOP_CHARGE("GiftshopCharge"),
    @XmlEnumValue("LaundryCharge")
    LAUNDRY_CHARGE("LaundryCharge"),
    @XmlEnumValue("ValetCharge")
    VALET_CHARGE("ValetCharge"),
    @XmlEnumValue("MovieCharge")
    MOVIE_CHARGE("MovieCharge"),
    @XmlEnumValue("BusinessCenterCharge")
    BUSINESS_CENTER_CHARGE("BusinessCenterCharge"),
    @XmlEnumValue("HealthClubCharge")
    HEALTH_CLUB_CHARGE("HealthClubCharge"),
    @XmlEnumValue("TransportationCharge")
    TRANSPORTATION_CHARGE("TransportationCharge"),
    @XmlEnumValue("ConferenceRoomCharge")
    CONFERENCE_ROOM_CHARGE("ConferenceRoomCharge"),
    @XmlEnumValue("BanquetCharge")
    BANQUET_CHARGE("BanquetCharge"),
    @XmlEnumValue("InternetAccessCharge")
    INTERNET_ACCESS_CHARGE("InternetAccessCharge"),
    @XmlEnumValue("RoomTaxCharge")
    ROOM_TAX_CHARGE("RoomTaxCharge"),
    @XmlEnumValue("NonRoomTaxCharge")
    NON_ROOM_TAX_CHARGE("NonRoomTaxCharge"),
    @XmlEnumValue("GratuityCharge")
    GRATUITY_CHARGE("GratuityCharge"),
    @XmlEnumValue("Gift")
    GIFT("Gift"),
    @XmlEnumValue("BusinessEntertainment")
    BUSINESS_ENTERTAINMENT("BusinessEntertainment"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("HotelDepositAmount")
    HOTEL_DEPOSIT_AMOUNT("HotelDepositAmount");
    private final String value;

    AxdEnumTrvHotelChargeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumTrvHotelChargeType fromValue(String v) {
        for (AxdEnumTrvHotelChargeType c: AxdEnumTrvHotelChargeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
