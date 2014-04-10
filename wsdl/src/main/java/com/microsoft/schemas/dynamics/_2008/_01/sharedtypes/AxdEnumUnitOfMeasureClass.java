
package com.microsoft.schemas.dynamics._2008._01.sharedtypes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AxdEnum_UnitOfMeasureClass.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AxdEnum_UnitOfMeasureClass">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Quantity"/>
 *     &lt;enumeration value="Length"/>
 *     &lt;enumeration value="Area"/>
 *     &lt;enumeration value="LiquidVolume"/>
 *     &lt;enumeration value="DryVolume"/>
 *     &lt;enumeration value="Mass"/>
 *     &lt;enumeration value="Time"/>
 *     &lt;enumeration value="Monetary"/>
 *     &lt;enumeration value="Temperature"/>
 *     &lt;enumeration value="InformationEntropy"/>
 *     &lt;enumeration value="Luminance"/>
 *     &lt;enumeration value="Speed"/>
 *     &lt;enumeration value="Acceleration"/>
 *     &lt;enumeration value="Angle"/>
 *     &lt;enumeration value="SolidAngle"/>
 *     &lt;enumeration value="Force"/>
 *     &lt;enumeration value="Pressure"/>
 *     &lt;enumeration value="Torque"/>
 *     &lt;enumeration value="Energy"/>
 *     &lt;enumeration value="Power"/>
 *     &lt;enumeration value="AngularMomentum"/>
 *     &lt;enumeration value="Capacitance"/>
 *     &lt;enumeration value="Density"/>
 *     &lt;enumeration value="ElectricCurrent"/>
 *     &lt;enumeration value="MagneticField"/>
 *     &lt;enumeration value="MagneticFlux"/>
 *     &lt;enumeration value="ElectricCharge"/>
 *     &lt;enumeration value="ElectricDipole"/>
 *     &lt;enumeration value="ElectricPotential"/>
 *     &lt;enumeration value="ElectricalResistance"/>
 *     &lt;enumeration value="Inductance"/>
 *     &lt;enumeration value="DynamicViscosity"/>
 *     &lt;enumeration value="KinematicViscosity"/>
 *     &lt;enumeration value="Radioactivity"/>
 *     &lt;enumeration value="Undefined"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AxdEnum_UnitOfMeasureClass")
@XmlEnum
public enum AxdEnumUnitOfMeasureClass {

    @XmlEnumValue("Quantity")
    QUANTITY("Quantity"),
    @XmlEnumValue("Length")
    LENGTH("Length"),
    @XmlEnumValue("Area")
    AREA("Area"),
    @XmlEnumValue("LiquidVolume")
    LIQUID_VOLUME("LiquidVolume"),
    @XmlEnumValue("DryVolume")
    DRY_VOLUME("DryVolume"),
    @XmlEnumValue("Mass")
    MASS("Mass"),
    @XmlEnumValue("Time")
    TIME("Time"),
    @XmlEnumValue("Monetary")
    MONETARY("Monetary"),
    @XmlEnumValue("Temperature")
    TEMPERATURE("Temperature"),
    @XmlEnumValue("InformationEntropy")
    INFORMATION_ENTROPY("InformationEntropy"),
    @XmlEnumValue("Luminance")
    LUMINANCE("Luminance"),
    @XmlEnumValue("Speed")
    SPEED("Speed"),
    @XmlEnumValue("Acceleration")
    ACCELERATION("Acceleration"),
    @XmlEnumValue("Angle")
    ANGLE("Angle"),
    @XmlEnumValue("SolidAngle")
    SOLID_ANGLE("SolidAngle"),
    @XmlEnumValue("Force")
    FORCE("Force"),
    @XmlEnumValue("Pressure")
    PRESSURE("Pressure"),
    @XmlEnumValue("Torque")
    TORQUE("Torque"),
    @XmlEnumValue("Energy")
    ENERGY("Energy"),
    @XmlEnumValue("Power")
    POWER("Power"),
    @XmlEnumValue("AngularMomentum")
    ANGULAR_MOMENTUM("AngularMomentum"),
    @XmlEnumValue("Capacitance")
    CAPACITANCE("Capacitance"),
    @XmlEnumValue("Density")
    DENSITY("Density"),
    @XmlEnumValue("ElectricCurrent")
    ELECTRIC_CURRENT("ElectricCurrent"),
    @XmlEnumValue("MagneticField")
    MAGNETIC_FIELD("MagneticField"),
    @XmlEnumValue("MagneticFlux")
    MAGNETIC_FLUX("MagneticFlux"),
    @XmlEnumValue("ElectricCharge")
    ELECTRIC_CHARGE("ElectricCharge"),
    @XmlEnumValue("ElectricDipole")
    ELECTRIC_DIPOLE("ElectricDipole"),
    @XmlEnumValue("ElectricPotential")
    ELECTRIC_POTENTIAL("ElectricPotential"),
    @XmlEnumValue("ElectricalResistance")
    ELECTRICAL_RESISTANCE("ElectricalResistance"),
    @XmlEnumValue("Inductance")
    INDUCTANCE("Inductance"),
    @XmlEnumValue("DynamicViscosity")
    DYNAMIC_VISCOSITY("DynamicViscosity"),
    @XmlEnumValue("KinematicViscosity")
    KINEMATIC_VISCOSITY("KinematicViscosity"),
    @XmlEnumValue("Radioactivity")
    RADIOACTIVITY("Radioactivity"),
    @XmlEnumValue("Undefined")
    UNDEFINED("Undefined");
    private final String value;

    AxdEnumUnitOfMeasureClass(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AxdEnumUnitOfMeasureClass fromValue(String v) {
        for (AxdEnumUnitOfMeasureClass c: AxdEnumUnitOfMeasureClass.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
