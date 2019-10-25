/**
 */
package org.sheepy.vulkan.model.image.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import org.sheepy.vulkan.model.image.ImageLayout;
import org.sheepy.vulkan.model.image.ImagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.image.impl.ImageLayoutImpl#getStage <em>Stage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.image.impl.ImageLayoutImpl#getLayout <em>Layout</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.image.impl.ImageLayoutImpl#getAccessMask <em>Access Mask</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImageLayoutImpl extends LilyEObject implements ImageLayout
{
	/**
	 * The default value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected static final EPipelineStage STAGE_EDEFAULT = EPipelineStage.TOP_OF_PIPE_BIT;

	/**
	 * The cached value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected EPipelineStage stage = STAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLayout() <em>Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayout()
	 * @generated
	 * @ordered
	 */
	protected static final EImageLayout LAYOUT_EDEFAULT = EImageLayout.SHADER_READ_ONLY_OPTIMAL;

	/**
	 * The cached value of the '{@link #getLayout() <em>Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayout()
	 * @generated
	 * @ordered
	 */
	protected EImageLayout layout = LAYOUT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAccessMask() <em>Access Mask</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessMask()
	 * @generated
	 * @ordered
	 */
	protected EList<EAccess> accessMask;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImageLayoutImpl()
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
		return ImagePackage.Literals.IMAGE_LAYOUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPipelineStage getStage()
	{
		return stage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStage(EPipelineStage newStage)
	{
		EPipelineStage oldStage = stage;
		stage = newStage == null ? STAGE_EDEFAULT : newStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE_LAYOUT__STAGE, oldStage, stage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EImageLayout getLayout()
	{
		return layout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLayout(EImageLayout newLayout)
	{
		EImageLayout oldLayout = layout;
		layout = newLayout == null ? LAYOUT_EDEFAULT : newLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImagePackage.IMAGE_LAYOUT__LAYOUT, oldLayout, layout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EAccess> getAccessMask()
	{
		if (accessMask == null)
		{
			accessMask = new EDataTypeUniqueEList<EAccess>(EAccess.class, this, ImagePackage.IMAGE_LAYOUT__ACCESS_MASK);
		}
		return accessMask;
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
			case ImagePackage.IMAGE_LAYOUT__STAGE:
				return getStage();
			case ImagePackage.IMAGE_LAYOUT__LAYOUT:
				return getLayout();
			case ImagePackage.IMAGE_LAYOUT__ACCESS_MASK:
				return getAccessMask();
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
			case ImagePackage.IMAGE_LAYOUT__STAGE:
				setStage((EPipelineStage)newValue);
				return;
			case ImagePackage.IMAGE_LAYOUT__LAYOUT:
				setLayout((EImageLayout)newValue);
				return;
			case ImagePackage.IMAGE_LAYOUT__ACCESS_MASK:
				getAccessMask().clear();
				getAccessMask().addAll((Collection<? extends EAccess>)newValue);
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
			case ImagePackage.IMAGE_LAYOUT__STAGE:
				setStage(STAGE_EDEFAULT);
				return;
			case ImagePackage.IMAGE_LAYOUT__LAYOUT:
				setLayout(LAYOUT_EDEFAULT);
				return;
			case ImagePackage.IMAGE_LAYOUT__ACCESS_MASK:
				getAccessMask().clear();
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
			case ImagePackage.IMAGE_LAYOUT__STAGE:
				return stage != STAGE_EDEFAULT;
			case ImagePackage.IMAGE_LAYOUT__LAYOUT:
				return layout != LAYOUT_EDEFAULT;
			case ImagePackage.IMAGE_LAYOUT__ACCESS_MASK:
				return accessMask != null && !accessMask.isEmpty();
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
		result.append(" (stage: ");
		result.append(stage);
		result.append(", layout: ");
		result.append(layout);
		result.append(", accessMask: ");
		result.append(accessMask);
		result.append(')');
		return result.toString();
	}

} //ImageLayoutImpl
