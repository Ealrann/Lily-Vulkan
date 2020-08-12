/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.core.model.ui.Font;

import org.sheepy.lily.vulkan.extra.model.nuklear.FontUsage;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Font Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.FontUsageImpl#getFont <em>Font</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.FontUsageImpl#getStrings <em>Strings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FontUsageImpl extends LilyEObject implements FontUsage
{
	/**
	 * The cached value of the '{@link #getFont() <em>Font</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFont()
	 * @generated
	 * @ordered
	 */
	protected Font font;

	/**
	 * The cached value of the '{@link #getStrings() <em>Strings</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrings()
	 * @generated
	 * @ordered
	 */
	protected EList<String> strings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FontUsageImpl()
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
		return NuklearPackage.Literals.FONT_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Font getFont()
	{
		if (font != null && ((EObject)font).eIsProxy())
		{
			InternalEObject oldFont = font;
			font = (Font)eResolveProxy(oldFont);
			if (font != oldFont)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NuklearPackage.FONT_USAGE__FONT, oldFont, font));
			}
		}
		return font;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Font basicGetFont()
	{
		return font;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFont(Font newFont)
	{
		Font oldFont = font;
		font = newFont;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.FONT_USAGE__FONT, oldFont, font));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getStrings()
	{
		if (strings == null)
		{
			strings = new EDataTypeUniqueEList<String>(String.class, this, NuklearPackage.FONT_USAGE__STRINGS);
		}
		return strings;
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
			case NuklearPackage.FONT_USAGE__FONT:
				if (resolve) return getFont();
				return basicGetFont();
			case NuklearPackage.FONT_USAGE__STRINGS:
				return getStrings();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case NuklearPackage.FONT_USAGE__FONT:
				setFont((Font)newValue);
				return;
			case NuklearPackage.FONT_USAGE__STRINGS:
				getStrings().clear();
				getStrings().addAll((Collection<? extends String>)newValue);
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
			case NuklearPackage.FONT_USAGE__FONT:
				setFont((Font)null);
				return;
			case NuklearPackage.FONT_USAGE__STRINGS:
				getStrings().clear();
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
			case NuklearPackage.FONT_USAGE__FONT:
				return font != null;
			case NuklearPackage.FONT_USAGE__STRINGS:
				return strings != null && !strings.isEmpty();
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
		result.append(" (strings: ");
		result.append(strings);
		result.append(')');
		return result.toString();
	}

} //FontUsageImpl
