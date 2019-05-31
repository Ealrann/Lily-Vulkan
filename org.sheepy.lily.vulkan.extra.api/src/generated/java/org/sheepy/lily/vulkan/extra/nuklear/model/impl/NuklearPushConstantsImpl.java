/**
 */
package org.sheepy.lily.vulkan.extra.nuklear.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPackage;
import org.sheepy.lily.vulkan.extra.nuklear.model.NuklearPushConstants;

import org.sheepy.lily.vulkan.model.process.impl.PushConstantImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Push Constants</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPushConstantsImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPushConstantsImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.nuklear.model.impl.NuklearPushConstantsImpl#getCurrentDescriptor <em>Current Descriptor</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NuklearPushConstantsImpl extends PushConstantImpl implements NuklearPushConstants
{
	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int WIDTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected int width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int HEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected int height = HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentDescriptor() <em>Current Descriptor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentDescriptor()
	 * @generated
	 * @ordered
	 */
	protected static final int CURRENT_DESCRIPTOR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCurrentDescriptor() <em>Current Descriptor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentDescriptor()
	 * @generated
	 * @ordered
	 */
	protected int currentDescriptor = CURRENT_DESCRIPTOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NuklearPushConstantsImpl()
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
		return NuklearPackage.Literals.NUKLEAR_PUSH_CONSTANTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getWidth()
	{
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWidth(int newWidth)
	{
		int oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_PUSH_CONSTANTS__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHeight()
	{
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeight(int newHeight)
	{
		int oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_PUSH_CONSTANTS__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCurrentDescriptor()
	{
		return currentDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrentDescriptor(int newCurrentDescriptor)
	{
		int oldCurrentDescriptor = currentDescriptor;
		currentDescriptor = newCurrentDescriptor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_PUSH_CONSTANTS__CURRENT_DESCRIPTOR, oldCurrentDescriptor, currentDescriptor));
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
			case NuklearPackage.NUKLEAR_PUSH_CONSTANTS__WIDTH:
				return getWidth();
			case NuklearPackage.NUKLEAR_PUSH_CONSTANTS__HEIGHT:
				return getHeight();
			case NuklearPackage.NUKLEAR_PUSH_CONSTANTS__CURRENT_DESCRIPTOR:
				return getCurrentDescriptor();
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
			case NuklearPackage.NUKLEAR_PUSH_CONSTANTS__WIDTH:
				setWidth((Integer)newValue);
				return;
			case NuklearPackage.NUKLEAR_PUSH_CONSTANTS__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case NuklearPackage.NUKLEAR_PUSH_CONSTANTS__CURRENT_DESCRIPTOR:
				setCurrentDescriptor((Integer)newValue);
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
			case NuklearPackage.NUKLEAR_PUSH_CONSTANTS__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case NuklearPackage.NUKLEAR_PUSH_CONSTANTS__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case NuklearPackage.NUKLEAR_PUSH_CONSTANTS__CURRENT_DESCRIPTOR:
				setCurrentDescriptor(CURRENT_DESCRIPTOR_EDEFAULT);
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
			case NuklearPackage.NUKLEAR_PUSH_CONSTANTS__WIDTH:
				return width != WIDTH_EDEFAULT;
			case NuklearPackage.NUKLEAR_PUSH_CONSTANTS__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case NuklearPackage.NUKLEAR_PUSH_CONSTANTS__CURRENT_DESCRIPTOR:
				return currentDescriptor != CURRENT_DESCRIPTOR_EDEFAULT;
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
		result.append(" (width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(", currentDescriptor: ");
		result.append(currentDescriptor);
		result.append(')');
		return result.toString();
	}

} //NuklearPushConstantsImpl
