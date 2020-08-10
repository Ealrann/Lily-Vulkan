/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.joml.Vector3dc;

import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.core.model.types.TypesFactory;
import org.sheepy.lily.core.model.types.TypesPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.Axis;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Axis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.AxisImpl#getFrontDirection <em>Front Direction</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.AxisImpl#getUpDirection <em>Up Direction</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.AxisImpl#getRightDirection <em>Right Direction</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AxisImpl extends LilyEObject implements Axis
{
	/**
	 * The default value of the '{@link #getFrontDirection() <em>Front Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrontDirection()
	 * @generated
	 * @ordered
	 */
	protected static final Vector3dc FRONT_DIRECTION_EDEFAULT = (Vector3dc)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getVector3d(), "0;0;0");

	/**
	 * The cached value of the '{@link #getFrontDirection() <em>Front Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrontDirection()
	 * @generated
	 * @ordered
	 */
	protected Vector3dc frontDirection = FRONT_DIRECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpDirection() <em>Up Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpDirection()
	 * @generated
	 * @ordered
	 */
	protected static final Vector3dc UP_DIRECTION_EDEFAULT = (Vector3dc)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getVector3d(), "0;0;0");

	/**
	 * The cached value of the '{@link #getUpDirection() <em>Up Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpDirection()
	 * @generated
	 * @ordered
	 */
	protected Vector3dc upDirection = UP_DIRECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRightDirection() <em>Right Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightDirection()
	 * @generated
	 * @ordered
	 */
	protected static final Vector3dc RIGHT_DIRECTION_EDEFAULT = (Vector3dc)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getVector3d(), "0;0;0");

	/**
	 * The cached value of the '{@link #getRightDirection() <em>Right Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightDirection()
	 * @generated
	 * @ordered
	 */
	protected Vector3dc rightDirection = RIGHT_DIRECTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AxisImpl()
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
		return RenderingPackage.Literals.AXIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector3dc getFrontDirection()
	{
		return frontDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFrontDirection(Vector3dc newFrontDirection)
	{
		Vector3dc oldFrontDirection = frontDirection;
		frontDirection = newFrontDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.AXIS__FRONT_DIRECTION, oldFrontDirection, frontDirection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector3dc getUpDirection()
	{
		return upDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUpDirection(Vector3dc newUpDirection)
	{
		Vector3dc oldUpDirection = upDirection;
		upDirection = newUpDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.AXIS__UP_DIRECTION, oldUpDirection, upDirection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector3dc getRightDirection()
	{
		return rightDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRightDirection(Vector3dc newRightDirection)
	{
		Vector3dc oldRightDirection = rightDirection;
		rightDirection = newRightDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.AXIS__RIGHT_DIRECTION, oldRightDirection, rightDirection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID) {
			case RenderingPackage.AXIS__FRONT_DIRECTION:
				return getFrontDirection();
			case RenderingPackage.AXIS__UP_DIRECTION:
				return getUpDirection();
			case RenderingPackage.AXIS__RIGHT_DIRECTION:
				return getRightDirection();
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
		switch (featureID) {
			case RenderingPackage.AXIS__FRONT_DIRECTION:
				setFrontDirection((Vector3dc)newValue);
				return;
			case RenderingPackage.AXIS__UP_DIRECTION:
				setUpDirection((Vector3dc)newValue);
				return;
			case RenderingPackage.AXIS__RIGHT_DIRECTION:
				setRightDirection((Vector3dc)newValue);
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
		switch (featureID) {
			case RenderingPackage.AXIS__FRONT_DIRECTION:
				setFrontDirection(FRONT_DIRECTION_EDEFAULT);
				return;
			case RenderingPackage.AXIS__UP_DIRECTION:
				setUpDirection(UP_DIRECTION_EDEFAULT);
				return;
			case RenderingPackage.AXIS__RIGHT_DIRECTION:
				setRightDirection(RIGHT_DIRECTION_EDEFAULT);
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
		switch (featureID) {
			case RenderingPackage.AXIS__FRONT_DIRECTION:
				return FRONT_DIRECTION_EDEFAULT == null ? frontDirection != null : !FRONT_DIRECTION_EDEFAULT.equals(frontDirection);
			case RenderingPackage.AXIS__UP_DIRECTION:
				return UP_DIRECTION_EDEFAULT == null ? upDirection != null : !UP_DIRECTION_EDEFAULT.equals(upDirection);
			case RenderingPackage.AXIS__RIGHT_DIRECTION:
				return RIGHT_DIRECTION_EDEFAULT == null ? rightDirection != null : !RIGHT_DIRECTION_EDEFAULT.equals(rightDirection);
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
		result.append(" (frontDirection: ");
		result.append(frontDirection);
		result.append(", upDirection: ");
		result.append(upDirection);
		result.append(", rightDirection: ");
		result.append(rightDirection);
		result.append(')');
		return result.toString();
	}

} //AxisImpl
