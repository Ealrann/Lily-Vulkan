/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.joml.Vector3dc;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.core.model.types.TypesFactory;
import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.Axis;
import org.sheepy.lily.vulkan.extra.model.rendering.Camera;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Camera</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.CameraImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.CameraImpl#getFieldOfView <em>Field Of View</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.CameraImpl#getZNear <em>ZNear</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.CameraImpl#getZFar <em>ZFar</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.CameraImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.CameraImpl#getAxis <em>Axis</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.CameraImpl#getLookDirection <em>Look Direction</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CameraImpl extends LilyEObject implements Camera
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
	 * The default value of the '{@link #getFieldOfView() <em>Field Of View</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldOfView()
	 * @generated
	 * @ordered
	 */
	protected static final float FIELD_OF_VIEW_EDEFAULT = 45.0F;

	/**
	 * The cached value of the '{@link #getFieldOfView() <em>Field Of View</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldOfView()
	 * @generated
	 * @ordered
	 */
	protected float fieldOfView = FIELD_OF_VIEW_EDEFAULT;

	/**
	 * The default value of the '{@link #getZNear() <em>ZNear</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZNear()
	 * @generated
	 * @ordered
	 */
	protected static final float ZNEAR_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getZNear() <em>ZNear</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZNear()
	 * @generated
	 * @ordered
	 */
	protected float zNear = ZNEAR_EDEFAULT;

	/**
	 * The default value of the '{@link #getZFar() <em>ZFar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZFar()
	 * @generated
	 * @ordered
	 */
	protected static final float ZFAR_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getZFar() <em>ZFar</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZFar()
	 * @generated
	 * @ordered
	 */
	protected float zFar = ZFAR_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final Vector3dc LOCATION_EDEFAULT = (Vector3dc)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getVector3d(), "0;0;0");

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected Vector3dc location = LOCATION_EDEFAULT;

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
	 * The default value of the '{@link #getLookDirection() <em>Look Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLookDirection()
	 * @generated
	 * @ordered
	 */
	protected static final Vector3dc LOOK_DIRECTION_EDEFAULT = (Vector3dc)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getVector3d(), "1;0;0");

	/**
	 * The cached value of the '{@link #getLookDirection() <em>Look Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLookDirection()
	 * @generated
	 * @ordered
	 */
	protected Vector3dc lookDirection = LOOK_DIRECTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CameraImpl()
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
		return RenderingPackage.Literals.CAMERA;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.CAMERA__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getFieldOfView()
	{
		return fieldOfView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFieldOfView(float newFieldOfView)
	{
		float oldFieldOfView = fieldOfView;
		fieldOfView = newFieldOfView;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.CAMERA__FIELD_OF_VIEW, oldFieldOfView, fieldOfView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getZNear()
	{
		return zNear;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setZNear(float newZNear)
	{
		float oldZNear = zNear;
		zNear = newZNear;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.CAMERA__ZNEAR, oldZNear, zNear));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getZFar()
	{
		return zFar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setZFar(float newZFar)
	{
		float oldZFar = zFar;
		zFar = newZFar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.CAMERA__ZFAR, oldZFar, zFar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector3dc getLocation()
	{
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLocation(Vector3dc newLocation)
	{
		Vector3dc oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.CAMERA__LOCATION, oldLocation, location));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RenderingPackage.CAMERA__AXIS, oldAxis, newAxis);
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
				msgs = ((InternalEObject)axis).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RenderingPackage.CAMERA__AXIS, null, msgs);
			if (newAxis != null)
				msgs = ((InternalEObject)newAxis).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RenderingPackage.CAMERA__AXIS, null, msgs);
			msgs = basicSetAxis(newAxis, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.CAMERA__AXIS, newAxis, newAxis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector3dc getLookDirection()
	{
		return lookDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLookDirection(Vector3dc newLookDirection)
	{
		Vector3dc oldLookDirection = lookDirection;
		lookDirection = newLookDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.CAMERA__LOOK_DIRECTION, oldLookDirection, lookDirection));
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
			case RenderingPackage.CAMERA__AXIS:
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
			case RenderingPackage.CAMERA__NAME:
				return getName();
			case RenderingPackage.CAMERA__FIELD_OF_VIEW:
				return getFieldOfView();
			case RenderingPackage.CAMERA__ZNEAR:
				return getZNear();
			case RenderingPackage.CAMERA__ZFAR:
				return getZFar();
			case RenderingPackage.CAMERA__LOCATION:
				return getLocation();
			case RenderingPackage.CAMERA__AXIS:
				return getAxis();
			case RenderingPackage.CAMERA__LOOK_DIRECTION:
				return getLookDirection();
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
			case RenderingPackage.CAMERA__NAME:
				setName((String)newValue);
				return;
			case RenderingPackage.CAMERA__FIELD_OF_VIEW:
				setFieldOfView((Float)newValue);
				return;
			case RenderingPackage.CAMERA__ZNEAR:
				setZNear((Float)newValue);
				return;
			case RenderingPackage.CAMERA__ZFAR:
				setZFar((Float)newValue);
				return;
			case RenderingPackage.CAMERA__LOCATION:
				setLocation((Vector3dc)newValue);
				return;
			case RenderingPackage.CAMERA__AXIS:
				setAxis((Axis)newValue);
				return;
			case RenderingPackage.CAMERA__LOOK_DIRECTION:
				setLookDirection((Vector3dc)newValue);
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
			case RenderingPackage.CAMERA__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RenderingPackage.CAMERA__FIELD_OF_VIEW:
				setFieldOfView(FIELD_OF_VIEW_EDEFAULT);
				return;
			case RenderingPackage.CAMERA__ZNEAR:
				setZNear(ZNEAR_EDEFAULT);
				return;
			case RenderingPackage.CAMERA__ZFAR:
				setZFar(ZFAR_EDEFAULT);
				return;
			case RenderingPackage.CAMERA__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case RenderingPackage.CAMERA__AXIS:
				setAxis((Axis)null);
				return;
			case RenderingPackage.CAMERA__LOOK_DIRECTION:
				setLookDirection(LOOK_DIRECTION_EDEFAULT);
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
			case RenderingPackage.CAMERA__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RenderingPackage.CAMERA__FIELD_OF_VIEW:
				return fieldOfView != FIELD_OF_VIEW_EDEFAULT;
			case RenderingPackage.CAMERA__ZNEAR:
				return zNear != ZNEAR_EDEFAULT;
			case RenderingPackage.CAMERA__ZFAR:
				return zFar != ZFAR_EDEFAULT;
			case RenderingPackage.CAMERA__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case RenderingPackage.CAMERA__AXIS:
				return axis != null;
			case RenderingPackage.CAMERA__LOOK_DIRECTION:
				return LOOK_DIRECTION_EDEFAULT == null ? lookDirection != null : !LOOK_DIRECTION_EDEFAULT.equals(lookDirection);
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
		result.append(", fieldOfView: ");
		result.append(fieldOfView);
		result.append(", zNear: ");
		result.append(zNear);
		result.append(", zFar: ");
		result.append(zFar);
		result.append(", location: ");
		result.append(location);
		result.append(", lookDirection: ");
		result.append(lookDirection);
		result.append(')');
		return result.toString();
	}

} //CameraImpl
