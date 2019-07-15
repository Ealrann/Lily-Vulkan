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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.ISwapAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;

import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.EPresentMode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Swapchain Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SwapchainConfigurationImpl#getPresentationMode <em>Presentation Mode</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SwapchainConfigurationImpl#getRequiredSwapImageCount <em>Required Swap Image Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SwapchainConfigurationImpl#getSwapImageUsages <em>Swap Image Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SwapchainConfigurationImpl#getAtachments <em>Atachments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SwapchainConfigurationImpl extends MinimalEObjectImpl.Container
		implements SwapchainConfiguration
{
	/**
	 * The default value of the '{@link #getPresentationMode() <em>Presentation Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentationMode()
	 * @generated
	 * @ordered
	 */
	protected static final EPresentMode PRESENTATION_MODE_EDEFAULT = EPresentMode.MAIL_BOX;

	/**
	 * The cached value of the '{@link #getPresentationMode() <em>Presentation Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentationMode()
	 * @generated
	 * @ordered
	 */
	protected EPresentMode presentationMode = PRESENTATION_MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRequiredSwapImageCount() <em>Required Swap Image Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredSwapImageCount()
	 * @generated
	 * @ordered
	 */
	protected static final int REQUIRED_SWAP_IMAGE_COUNT_EDEFAULT = 3;

	/**
	 * The cached value of the '{@link #getRequiredSwapImageCount() <em>Required Swap Image Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredSwapImageCount()
	 * @generated
	 * @ordered
	 */
	protected int requiredSwapImageCount = REQUIRED_SWAP_IMAGE_COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSwapImageUsages() <em>Swap Image Usages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwapImageUsages()
	 * @generated
	 * @ordered
	 */
	protected EList<EImageUsage> swapImageUsages;

	/**
	 * The cached value of the '{@link #getAtachments() <em>Atachments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtachments()
	 * @generated
	 * @ordered
	 */
	protected EList<ISwapAttachment> atachments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwapchainConfigurationImpl()
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
		return GraphicPackage.Literals.SWAPCHAIN_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPresentMode getPresentationMode()
	{
		return presentationMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPresentationMode(EPresentMode newPresentationMode)
	{
		EPresentMode oldPresentationMode = presentationMode;
		presentationMode = newPresentationMode == null
				? PRESENTATION_MODE_EDEFAULT
				: newPresentationMode;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.SWAPCHAIN_CONFIGURATION__PRESENTATION_MODE, oldPresentationMode,
				presentationMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getRequiredSwapImageCount()
	{
		return requiredSwapImageCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequiredSwapImageCount(int newRequiredSwapImageCount)
	{
		int oldRequiredSwapImageCount = requiredSwapImageCount;
		requiredSwapImageCount = newRequiredSwapImageCount;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.SWAPCHAIN_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT,
				oldRequiredSwapImageCount, requiredSwapImageCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EImageUsage> getSwapImageUsages()
	{
		if (swapImageUsages == null)
		{
			swapImageUsages = new EDataTypeUniqueEList<EImageUsage>(EImageUsage.class, this,
					GraphicPackage.SWAPCHAIN_CONFIGURATION__SWAP_IMAGE_USAGES);
		}
		return swapImageUsages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ISwapAttachment> getAtachments()
	{
		if (atachments == null)
		{
			atachments = new EObjectContainmentEList<ISwapAttachment>(ISwapAttachment.class, this,
					GraphicPackage.SWAPCHAIN_CONFIGURATION__ATACHMENTS);
		}
		return atachments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
											int featureID,
											NotificationChain msgs)
	{
		switch (featureID)
		{
		case GraphicPackage.SWAPCHAIN_CONFIGURATION__ATACHMENTS:
			return ((InternalEList<?>) getAtachments()).basicRemove(otherEnd, msgs);
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
		case GraphicPackage.SWAPCHAIN_CONFIGURATION__PRESENTATION_MODE:
			return getPresentationMode();
		case GraphicPackage.SWAPCHAIN_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT:
			return getRequiredSwapImageCount();
		case GraphicPackage.SWAPCHAIN_CONFIGURATION__SWAP_IMAGE_USAGES:
			return getSwapImageUsages();
		case GraphicPackage.SWAPCHAIN_CONFIGURATION__ATACHMENTS:
			return getAtachments();
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
		case GraphicPackage.SWAPCHAIN_CONFIGURATION__PRESENTATION_MODE:
			setPresentationMode((EPresentMode) newValue);
			return;
		case GraphicPackage.SWAPCHAIN_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT:
			setRequiredSwapImageCount((Integer) newValue);
			return;
		case GraphicPackage.SWAPCHAIN_CONFIGURATION__SWAP_IMAGE_USAGES:
			getSwapImageUsages().clear();
			getSwapImageUsages().addAll((Collection<? extends EImageUsage>) newValue);
			return;
		case GraphicPackage.SWAPCHAIN_CONFIGURATION__ATACHMENTS:
			getAtachments().clear();
			getAtachments().addAll((Collection<? extends ISwapAttachment>) newValue);
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
		case GraphicPackage.SWAPCHAIN_CONFIGURATION__PRESENTATION_MODE:
			setPresentationMode(PRESENTATION_MODE_EDEFAULT);
			return;
		case GraphicPackage.SWAPCHAIN_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT:
			setRequiredSwapImageCount(REQUIRED_SWAP_IMAGE_COUNT_EDEFAULT);
			return;
		case GraphicPackage.SWAPCHAIN_CONFIGURATION__SWAP_IMAGE_USAGES:
			getSwapImageUsages().clear();
			return;
		case GraphicPackage.SWAPCHAIN_CONFIGURATION__ATACHMENTS:
			getAtachments().clear();
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
		case GraphicPackage.SWAPCHAIN_CONFIGURATION__PRESENTATION_MODE:
			return presentationMode != PRESENTATION_MODE_EDEFAULT;
		case GraphicPackage.SWAPCHAIN_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT:
			return requiredSwapImageCount != REQUIRED_SWAP_IMAGE_COUNT_EDEFAULT;
		case GraphicPackage.SWAPCHAIN_CONFIGURATION__SWAP_IMAGE_USAGES:
			return swapImageUsages != null && !swapImageUsages.isEmpty();
		case GraphicPackage.SWAPCHAIN_CONFIGURATION__ATACHMENTS:
			return atachments != null && !atachments.isEmpty();
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
		result.append(" (presentationMode: ");
		result.append(presentationMode);
		result.append(", requiredSwapImageCount: ");
		result.append(requiredSwapImageCount);
		result.append(", swapImageUsages: ");
		result.append(swapImageUsages);
		result.append(')');
		return result.toString();
	}

} //SwapchainConfigurationImpl
