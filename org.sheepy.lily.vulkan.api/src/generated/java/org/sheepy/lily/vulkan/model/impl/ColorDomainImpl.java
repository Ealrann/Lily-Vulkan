/**
 */
package org.sheepy.vulkan.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.vulkan.model.ColorDomain;
import org.sheepy.vulkan.model.VulkanPackage;

import org.sheepy.vulkan.model.enumeration.EColorSpace;
import org.sheepy.vulkan.model.enumeration.EFormat;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Color Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.impl.ColorDomainImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.impl.ColorDomainImpl#getColorSpace <em>Color Space</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ColorDomainImpl extends MinimalEObjectImpl.Container implements ColorDomain
{
	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final EFormat FORMAT_EDEFAULT = EFormat.B8G8R8A8_UNORM;

	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected EFormat format = FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getColorSpace() <em>Color Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorSpace()
	 * @generated
	 * @ordered
	 */
	protected static final EColorSpace COLOR_SPACE_EDEFAULT = EColorSpace.SRGB_NONLINEAR_KHR;

	/**
	 * The cached value of the '{@link #getColorSpace() <em>Color Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorSpace()
	 * @generated
	 * @ordered
	 */
	protected EColorSpace colorSpace = COLOR_SPACE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorDomainImpl()
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
		return VulkanPackage.Literals.COLOR_DOMAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EFormat getFormat()
	{
		return format;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFormat(EFormat newFormat)
	{
		EFormat oldFormat = format;
		format = newFormat == null ? FORMAT_EDEFAULT : newFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.COLOR_DOMAIN__FORMAT, oldFormat, format));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EColorSpace getColorSpace()
	{
		return colorSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColorSpace(EColorSpace newColorSpace)
	{
		EColorSpace oldColorSpace = colorSpace;
		colorSpace = newColorSpace == null ? COLOR_SPACE_EDEFAULT : newColorSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanPackage.COLOR_DOMAIN__COLOR_SPACE, oldColorSpace, colorSpace));
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
			case VulkanPackage.COLOR_DOMAIN__FORMAT:
				return getFormat();
			case VulkanPackage.COLOR_DOMAIN__COLOR_SPACE:
				return getColorSpace();
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
			case VulkanPackage.COLOR_DOMAIN__FORMAT:
				setFormat((EFormat)newValue);
				return;
			case VulkanPackage.COLOR_DOMAIN__COLOR_SPACE:
				setColorSpace((EColorSpace)newValue);
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
			case VulkanPackage.COLOR_DOMAIN__FORMAT:
				setFormat(FORMAT_EDEFAULT);
				return;
			case VulkanPackage.COLOR_DOMAIN__COLOR_SPACE:
				setColorSpace(COLOR_SPACE_EDEFAULT);
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
			case VulkanPackage.COLOR_DOMAIN__FORMAT:
				return format != FORMAT_EDEFAULT;
			case VulkanPackage.COLOR_DOMAIN__COLOR_SPACE:
				return colorSpace != COLOR_SPACE_EDEFAULT;
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
		result.append(" (format: ");
		result.append(format);
		result.append(", colorSpace: ");
		result.append(colorSpace);
		result.append(')');
		return result.toString();
	}

} //ColorDomainImpl
