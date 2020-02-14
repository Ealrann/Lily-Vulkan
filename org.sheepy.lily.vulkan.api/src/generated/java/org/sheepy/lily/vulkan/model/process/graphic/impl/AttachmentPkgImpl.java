/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attachment Pkg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentPkgImpl#getColorAttachment <em>Color Attachment</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentPkgImpl#getExtraAttachments <em>Extra Attachments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttachmentPkgImpl extends LilyEObject implements AttachmentPkg
{
	/**
	 * The cached value of the '{@link #getColorAttachment() <em>Color Attachment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorAttachment()
	 * @generated
	 * @ordered
	 */
	protected SwapImageAttachment colorAttachment;

	/**
	 * The cached value of the '{@link #getExtraAttachments() <em>Extra Attachments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtraAttachments()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtraAttachment> extraAttachments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttachmentPkgImpl()
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
		return GraphicPackage.Literals.ATTACHMENT_PKG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ExtraAttachment> getExtraAttachments()
	{
		if (extraAttachments == null)
		{
			extraAttachments = new EObjectContainmentEList<ExtraAttachment>(ExtraAttachment.class, this, GraphicPackage.ATTACHMENT_PKG__EXTRA_ATTACHMENTS);
		}
		return extraAttachments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SwapImageAttachment getColorAttachment()
	{
		return colorAttachment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetColorAttachment(SwapImageAttachment newColorAttachment, NotificationChain msgs)
	{
		SwapImageAttachment oldColorAttachment = colorAttachment;
		colorAttachment = newColorAttachment;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.ATTACHMENT_PKG__COLOR_ATTACHMENT, oldColorAttachment, newColorAttachment);
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
	public void setColorAttachment(SwapImageAttachment newColorAttachment)
	{
		if (newColorAttachment != colorAttachment)
		{
			NotificationChain msgs = null;
			if (colorAttachment != null)
				msgs = ((InternalEObject)colorAttachment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.ATTACHMENT_PKG__COLOR_ATTACHMENT, null, msgs);
			if (newColorAttachment != null)
				msgs = ((InternalEObject)newColorAttachment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.ATTACHMENT_PKG__COLOR_ATTACHMENT, null, msgs);
			msgs = basicSetColorAttachment(newColorAttachment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.ATTACHMENT_PKG__COLOR_ATTACHMENT, newColorAttachment, newColorAttachment));
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
			case GraphicPackage.ATTACHMENT_PKG__COLOR_ATTACHMENT:
				return basicSetColorAttachment(null, msgs);
			case GraphicPackage.ATTACHMENT_PKG__EXTRA_ATTACHMENTS:
				return ((InternalEList<?>)getExtraAttachments()).basicRemove(otherEnd, msgs);
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
			case GraphicPackage.ATTACHMENT_PKG__COLOR_ATTACHMENT:
				return getColorAttachment();
			case GraphicPackage.ATTACHMENT_PKG__EXTRA_ATTACHMENTS:
				return getExtraAttachments();
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
			case GraphicPackage.ATTACHMENT_PKG__COLOR_ATTACHMENT:
				setColorAttachment((SwapImageAttachment)newValue);
				return;
			case GraphicPackage.ATTACHMENT_PKG__EXTRA_ATTACHMENTS:
				getExtraAttachments().clear();
				getExtraAttachments().addAll((Collection<? extends ExtraAttachment>)newValue);
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
			case GraphicPackage.ATTACHMENT_PKG__COLOR_ATTACHMENT:
				setColorAttachment((SwapImageAttachment)null);
				return;
			case GraphicPackage.ATTACHMENT_PKG__EXTRA_ATTACHMENTS:
				getExtraAttachments().clear();
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
			case GraphicPackage.ATTACHMENT_PKG__COLOR_ATTACHMENT:
				return colorAttachment != null;
			case GraphicPackage.ATTACHMENT_PKG__EXTRA_ATTACHMENTS:
				return extraAttachments != null && !extraAttachments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AttachmentPkgImpl
