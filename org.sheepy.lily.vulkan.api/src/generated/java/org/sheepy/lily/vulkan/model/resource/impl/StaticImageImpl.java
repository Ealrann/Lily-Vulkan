/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import java.nio.ByteBuffer;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.joml.Vector2ic;

import org.sheepy.lily.core.model.types.TypesFactory;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.vulkan.model.resource.StaticImage;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Static Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#isFillWithZero <em>Fill With Zero</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#getFillWith <em>Fill With</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.StaticImageImpl#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StaticImageImpl extends ImageImpl implements StaticImage
{
	/**
	 * The default value of the '{@link #isFillWithZero() <em>Fill With Zero</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFillWithZero()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FILL_WITH_ZERO_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFillWithZero() <em>Fill With Zero</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFillWithZero()
	 * @generated
	 * @ordered
	 */
	protected boolean fillWithZero = FILL_WITH_ZERO_EDEFAULT;

	/**
	 * The default value of the '{@link #getFillWith() <em>Fill With</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFillWith()
	 * @generated
	 * @ordered
	 */
	protected static final ByteBuffer FILL_WITH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFillWith() <em>Fill With</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFillWith()
	 * @generated
	 * @ordered
	 */
	protected ByteBuffer fillWith = FILL_WITH_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final Vector2ic SIZE_EDEFAULT = (Vector2ic)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getVector2i(), "1;1");

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected Vector2ic size = SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StaticImageImpl()
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
		return VulkanResourcePackage.Literals.STATIC_IMAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFillWithZero()
	{
		return fillWithZero;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFillWithZero(boolean newFillWithZero)
	{
		boolean oldFillWithZero = fillWithZero;
		fillWithZero = newFillWithZero;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.STATIC_IMAGE__FILL_WITH_ZERO, oldFillWithZero, fillWithZero));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ByteBuffer getFillWith()
	{
		return fillWith;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFillWith(ByteBuffer newFillWith)
	{
		ByteBuffer oldFillWith = fillWith;
		fillWith = newFillWith;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.STATIC_IMAGE__FILL_WITH, oldFillWith, fillWith));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector2ic getSize()
	{
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(Vector2ic newSize)
	{
		Vector2ic oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.STATIC_IMAGE__SIZE, oldSize, size));
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
			case VulkanResourcePackage.STATIC_IMAGE__FILL_WITH_ZERO:
				return isFillWithZero();
			case VulkanResourcePackage.STATIC_IMAGE__FILL_WITH:
				return getFillWith();
			case VulkanResourcePackage.STATIC_IMAGE__SIZE:
				return getSize();
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
			case VulkanResourcePackage.STATIC_IMAGE__FILL_WITH_ZERO:
				setFillWithZero((Boolean)newValue);
				return;
			case VulkanResourcePackage.STATIC_IMAGE__FILL_WITH:
				setFillWith((ByteBuffer)newValue);
				return;
			case VulkanResourcePackage.STATIC_IMAGE__SIZE:
				setSize((Vector2ic)newValue);
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
			case VulkanResourcePackage.STATIC_IMAGE__FILL_WITH_ZERO:
				setFillWithZero(FILL_WITH_ZERO_EDEFAULT);
				return;
			case VulkanResourcePackage.STATIC_IMAGE__FILL_WITH:
				setFillWith(FILL_WITH_EDEFAULT);
				return;
			case VulkanResourcePackage.STATIC_IMAGE__SIZE:
				setSize(SIZE_EDEFAULT);
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
			case VulkanResourcePackage.STATIC_IMAGE__FILL_WITH_ZERO:
				return fillWithZero != FILL_WITH_ZERO_EDEFAULT;
			case VulkanResourcePackage.STATIC_IMAGE__FILL_WITH:
				return FILL_WITH_EDEFAULT == null ? fillWith != null : !FILL_WITH_EDEFAULT.equals(fillWith);
			case VulkanResourcePackage.STATIC_IMAGE__SIZE:
				return SIZE_EDEFAULT == null ? size != null : !SIZE_EDEFAULT.equals(size);
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
		result.append(" (fillWithZero: ");
		result.append(fillWithZero);
		result.append(", fillWith: ");
		result.append(fillWith);
		result.append(", size: ");
		result.append(size);
		result.append(')');
		return result.toString();
	}

} //StaticImageImpl
