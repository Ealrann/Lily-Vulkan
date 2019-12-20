/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.model.application.impl.IResourceImpl;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;

import org.sheepy.lily.vulkan.model.resource.SampledImage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Font</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearFontImpl#getFontSampledImage <em>Font Sampled Image</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NuklearFontImpl extends IResourceImpl implements NuklearFont
{
	/**
	 * The cached value of the '{@link #getFontSampledImage() <em>Font Sampled Image</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFontSampledImage()
	 * @generated
	 * @ordered
	 */
	protected SampledImage fontSampledImage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NuklearFontImpl()
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
		return NuklearPackage.Literals.NUKLEAR_FONT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SampledImage getFontSampledImage()
	{
		return fontSampledImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFontSampledImage(SampledImage newFontSampledImage, NotificationChain msgs)
	{
		SampledImage oldFontSampledImage = fontSampledImage;
		fontSampledImage = newFontSampledImage;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_FONT__FONT_SAMPLED_IMAGE, oldFontSampledImage, newFontSampledImage);
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
	public void setFontSampledImage(SampledImage newFontSampledImage)
	{
		if (newFontSampledImage != fontSampledImage)
		{
			NotificationChain msgs = null;
			if (fontSampledImage != null)
				msgs = ((InternalEObject)fontSampledImage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NuklearPackage.NUKLEAR_FONT__FONT_SAMPLED_IMAGE, null, msgs);
			if (newFontSampledImage != null)
				msgs = ((InternalEObject)newFontSampledImage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NuklearPackage.NUKLEAR_FONT__FONT_SAMPLED_IMAGE, null, msgs);
			msgs = basicSetFontSampledImage(newFontSampledImage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.NUKLEAR_FONT__FONT_SAMPLED_IMAGE, newFontSampledImage, newFontSampledImage));
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
			case NuklearPackage.NUKLEAR_FONT__FONT_SAMPLED_IMAGE:
				return basicSetFontSampledImage(null, msgs);
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
			case NuklearPackage.NUKLEAR_FONT__FONT_SAMPLED_IMAGE:
				return getFontSampledImage();
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
			case NuklearPackage.NUKLEAR_FONT__FONT_SAMPLED_IMAGE:
				setFontSampledImage((SampledImage)newValue);
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
			case NuklearPackage.NUKLEAR_FONT__FONT_SAMPLED_IMAGE:
				setFontSampledImage((SampledImage)null);
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
			case NuklearPackage.NUKLEAR_FONT__FONT_SAMPLED_IMAGE:
				return fontSampledImage != null;
		}
		return super.eIsSet(featureID);
	}

} //NuklearFontImpl
