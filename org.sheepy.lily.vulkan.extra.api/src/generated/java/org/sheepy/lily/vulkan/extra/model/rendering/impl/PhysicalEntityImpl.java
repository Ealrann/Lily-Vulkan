/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.joml.Vector2fc;
import org.joml.Vector3dc;

import org.sheepy.lily.core.model.types.TypesFactory;
import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.Axis;
import org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Physical Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityImpl#getGeoLocation <em>Geo Location</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityImpl#getGeoOrientation <em>Geo Orientation</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityImpl#getAxisLocation <em>Axis Location</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityImpl#getAxis <em>Axis</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PhysicalEntityImpl extends MinimalEObjectImpl.Container implements PhysicalEntity
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getGeoLocation() <em>Geo Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeoLocation()
	 * @generated
	 * @ordered
	 */
	protected static final Vector3dc GEO_LOCATION_EDEFAULT = (Vector3dc)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getVector3d(), "0;0;0");

	/**
	 * The cached value of the '{@link #getGeoLocation() <em>Geo Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeoLocation()
	 * @generated
	 * @ordered
	 */
	protected Vector3dc geoLocation = GEO_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getGeoOrientation() <em>Geo Orientation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeoOrientation()
	 * @generated
	 * @ordered
	 */
	protected static final Vector2fc GEO_ORIENTATION_EDEFAULT = (Vector2fc)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getVector2f(), "0;0;0");

	/**
	 * The cached value of the '{@link #getGeoOrientation() <em>Geo Orientation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeoOrientation()
	 * @generated
	 * @ordered
	 */
	protected Vector2fc geoOrientation = GEO_ORIENTATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAxisLocation() <em>Axis Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAxisLocation()
	 * @generated
	 * @ordered
	 */
	protected static final Vector3dc AXIS_LOCATION_EDEFAULT = (Vector3dc)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getVector3d(), "0;0;0");

	/**
	 * The cached value of the '{@link #getAxisLocation() <em>Axis Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAxisLocation()
	 * @generated
	 * @ordered
	 */
	protected Vector3dc axisLocation = AXIS_LOCATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAxis() <em>Axis</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAxis()
	 * @generated
	 * @ordered
	 */
	protected Axis axis;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhysicalEntityImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return RenderingPackage.Literals.PHYSICAL_ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.PHYSICAL_ENTITY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector3dc getGeoLocation()
	{
		return geoLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGeoLocation(Vector3dc newGeoLocation)
	{
		Vector3dc oldGeoLocation = geoLocation;
		geoLocation = newGeoLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.PHYSICAL_ENTITY__GEO_LOCATION, oldGeoLocation, geoLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector2fc getGeoOrientation()
	{
		return geoOrientation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGeoOrientation(Vector2fc newGeoOrientation)
	{
		Vector2fc oldGeoOrientation = geoOrientation;
		geoOrientation = newGeoOrientation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.PHYSICAL_ENTITY__GEO_ORIENTATION, oldGeoOrientation, geoOrientation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector3dc getAxisLocation()
	{
		return axisLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAxisLocation(Vector3dc newAxisLocation)
	{
		Vector3dc oldAxisLocation = axisLocation;
		axisLocation = newAxisLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.PHYSICAL_ENTITY__AXIS_LOCATION, oldAxisLocation, axisLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Axis getAxis()
	{
		return axis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAxis(Axis newAxis, NotificationChain msgs)
	{
		Axis oldAxis = axis;
		axis = newAxis;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RenderingPackage.PHYSICAL_ENTITY__AXIS, oldAxis, newAxis);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAxis(Axis newAxis)
	{
		if (newAxis != axis)
		{
			NotificationChain msgs = null;
			if (axis != null)
				msgs = ((InternalEObject)axis).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RenderingPackage.PHYSICAL_ENTITY__AXIS, null, msgs);
			if (newAxis != null)
				msgs = ((InternalEObject)newAxis).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RenderingPackage.PHYSICAL_ENTITY__AXIS, null, msgs);
			msgs = basicSetAxis(newAxis, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.PHYSICAL_ENTITY__AXIS, newAxis, newAxis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case RenderingPackage.PHYSICAL_ENTITY__AXIS:
				return basicSetAxis(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case RenderingPackage.PHYSICAL_ENTITY__NAME:
				return getName();
			case RenderingPackage.PHYSICAL_ENTITY__GEO_LOCATION:
				return getGeoLocation();
			case RenderingPackage.PHYSICAL_ENTITY__GEO_ORIENTATION:
				return getGeoOrientation();
			case RenderingPackage.PHYSICAL_ENTITY__AXIS_LOCATION:
				return getAxisLocation();
			case RenderingPackage.PHYSICAL_ENTITY__AXIS:
				return getAxis();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case RenderingPackage.PHYSICAL_ENTITY__NAME:
				setName((String)newValue);
				return;
			case RenderingPackage.PHYSICAL_ENTITY__GEO_LOCATION:
				setGeoLocation((Vector3dc)newValue);
				return;
			case RenderingPackage.PHYSICAL_ENTITY__GEO_ORIENTATION:
				setGeoOrientation((Vector2fc)newValue);
				return;
			case RenderingPackage.PHYSICAL_ENTITY__AXIS_LOCATION:
				setAxisLocation((Vector3dc)newValue);
				return;
			case RenderingPackage.PHYSICAL_ENTITY__AXIS:
				setAxis((Axis)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case RenderingPackage.PHYSICAL_ENTITY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RenderingPackage.PHYSICAL_ENTITY__GEO_LOCATION:
				setGeoLocation(GEO_LOCATION_EDEFAULT);
				return;
			case RenderingPackage.PHYSICAL_ENTITY__GEO_ORIENTATION:
				setGeoOrientation(GEO_ORIENTATION_EDEFAULT);
				return;
			case RenderingPackage.PHYSICAL_ENTITY__AXIS_LOCATION:
				setAxisLocation(AXIS_LOCATION_EDEFAULT);
				return;
			case RenderingPackage.PHYSICAL_ENTITY__AXIS:
				setAxis((Axis)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case RenderingPackage.PHYSICAL_ENTITY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RenderingPackage.PHYSICAL_ENTITY__GEO_LOCATION:
				return GEO_LOCATION_EDEFAULT == null ? geoLocation != null : !GEO_LOCATION_EDEFAULT.equals(geoLocation);
			case RenderingPackage.PHYSICAL_ENTITY__GEO_ORIENTATION:
				return GEO_ORIENTATION_EDEFAULT == null ? geoOrientation != null : !GEO_ORIENTATION_EDEFAULT.equals(geoOrientation);
			case RenderingPackage.PHYSICAL_ENTITY__AXIS_LOCATION:
				return AXIS_LOCATION_EDEFAULT == null ? axisLocation != null : !AXIS_LOCATION_EDEFAULT.equals(axisLocation);
			case RenderingPackage.PHYSICAL_ENTITY__AXIS:
				return axis != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", geoLocation: ");
		result.append(geoLocation);
		result.append(", geoOrientation: ");
		result.append(geoOrientation);
		result.append(", axisLocation: ");
		result.append(axisLocation);
		result.append(')');
		return result.toString();
	}

} //PhysicalEntityImpl
