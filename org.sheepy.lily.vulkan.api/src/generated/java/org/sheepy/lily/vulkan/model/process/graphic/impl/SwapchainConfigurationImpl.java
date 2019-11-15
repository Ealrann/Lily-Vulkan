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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.ISwapAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;

import org.sheepy.vulkan.model.enumeration.EImageUsage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Swapchain Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SwapchainConfigurationImpl#getRequiredSwapImageCount <em>Required Swap Image Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SwapchainConfigurationImpl#getSwapImageUsages <em>Swap Image Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SwapchainConfigurationImpl#getAtachments <em>Atachments</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SwapchainConfigurationImpl#isPresentWhenVBlank <em>Present When VBlank</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SwapchainConfigurationImpl#isAcquireWaitForVBlank <em>Acquire Wait For VBlank</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.SwapchainConfigurationImpl#isAllowingAccessFromCompute <em>Allowing Access From Compute</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SwapchainConfigurationImpl extends LilyEObject implements SwapchainConfiguration
{
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
	 * The default value of the '{@link #isPresentWhenVBlank() <em>Present When VBlank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPresentWhenVBlank()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRESENT_WHEN_VBLANK_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isPresentWhenVBlank() <em>Present When VBlank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPresentWhenVBlank()
	 * @generated
	 * @ordered
	 */
	protected boolean presentWhenVBlank = PRESENT_WHEN_VBLANK_EDEFAULT;

	/**
	 * The default value of the '{@link #isAcquireWaitForVBlank() <em>Acquire Wait For VBlank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAcquireWaitForVBlank()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACQUIRE_WAIT_FOR_VBLANK_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAcquireWaitForVBlank() <em>Acquire Wait For VBlank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAcquireWaitForVBlank()
	 * @generated
	 * @ordered
	 */
	protected boolean acquireWaitForVBlank = ACQUIRE_WAIT_FOR_VBLANK_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllowingAccessFromCompute() <em>Allowing Access From Compute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowingAccessFromCompute()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOWING_ACCESS_FROM_COMPUTE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllowingAccessFromCompute() <em>Allowing Access From Compute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowingAccessFromCompute()
	 * @generated
	 * @ordered
	 */
	protected boolean allowingAccessFromCompute = ALLOWING_ACCESS_FROM_COMPUTE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwapchainConfigurationImpl()
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SWAPCHAIN_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT, oldRequiredSwapImageCount, requiredSwapImageCount));
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
			swapImageUsages = new EDataTypeUniqueEList<EImageUsage>(EImageUsage.class, this, GraphicPackage.SWAPCHAIN_CONFIGURATION__SWAP_IMAGE_USAGES);
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
			atachments = new EObjectContainmentEList<ISwapAttachment>(ISwapAttachment.class, this, GraphicPackage.SWAPCHAIN_CONFIGURATION__ATACHMENTS);
		}
		return atachments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPresentWhenVBlank()
	{
		return presentWhenVBlank;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPresentWhenVBlank(boolean newPresentWhenVBlank)
	{
		boolean oldPresentWhenVBlank = presentWhenVBlank;
		presentWhenVBlank = newPresentWhenVBlank;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SWAPCHAIN_CONFIGURATION__PRESENT_WHEN_VBLANK, oldPresentWhenVBlank, presentWhenVBlank));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAcquireWaitForVBlank()
	{
		return acquireWaitForVBlank;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAcquireWaitForVBlank(boolean newAcquireWaitForVBlank)
	{
		boolean oldAcquireWaitForVBlank = acquireWaitForVBlank;
		acquireWaitForVBlank = newAcquireWaitForVBlank;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SWAPCHAIN_CONFIGURATION__ACQUIRE_WAIT_FOR_VBLANK, oldAcquireWaitForVBlank, acquireWaitForVBlank));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAllowingAccessFromCompute()
	{
		return allowingAccessFromCompute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAllowingAccessFromCompute(boolean newAllowingAccessFromCompute)
	{
		boolean oldAllowingAccessFromCompute = allowingAccessFromCompute;
		allowingAccessFromCompute = newAllowingAccessFromCompute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.SWAPCHAIN_CONFIGURATION__ALLOWING_ACCESS_FROM_COMPUTE, oldAllowingAccessFromCompute, allowingAccessFromCompute));
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
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__ATACHMENTS:
				return ((InternalEList<?>)getAtachments()).basicRemove(otherEnd, msgs);
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
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT:
				return getRequiredSwapImageCount();
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__SWAP_IMAGE_USAGES:
				return getSwapImageUsages();
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__ATACHMENTS:
				return getAtachments();
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__PRESENT_WHEN_VBLANK:
				return isPresentWhenVBlank();
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__ACQUIRE_WAIT_FOR_VBLANK:
				return isAcquireWaitForVBlank();
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__ALLOWING_ACCESS_FROM_COMPUTE:
				return isAllowingAccessFromCompute();
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
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT:
				setRequiredSwapImageCount((Integer)newValue);
				return;
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__SWAP_IMAGE_USAGES:
				getSwapImageUsages().clear();
				getSwapImageUsages().addAll((Collection<? extends EImageUsage>)newValue);
				return;
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__ATACHMENTS:
				getAtachments().clear();
				getAtachments().addAll((Collection<? extends ISwapAttachment>)newValue);
				return;
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__PRESENT_WHEN_VBLANK:
				setPresentWhenVBlank((Boolean)newValue);
				return;
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__ACQUIRE_WAIT_FOR_VBLANK:
				setAcquireWaitForVBlank((Boolean)newValue);
				return;
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__ALLOWING_ACCESS_FROM_COMPUTE:
				setAllowingAccessFromCompute((Boolean)newValue);
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
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT:
				setRequiredSwapImageCount(REQUIRED_SWAP_IMAGE_COUNT_EDEFAULT);
				return;
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__SWAP_IMAGE_USAGES:
				getSwapImageUsages().clear();
				return;
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__ATACHMENTS:
				getAtachments().clear();
				return;
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__PRESENT_WHEN_VBLANK:
				setPresentWhenVBlank(PRESENT_WHEN_VBLANK_EDEFAULT);
				return;
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__ACQUIRE_WAIT_FOR_VBLANK:
				setAcquireWaitForVBlank(ACQUIRE_WAIT_FOR_VBLANK_EDEFAULT);
				return;
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__ALLOWING_ACCESS_FROM_COMPUTE:
				setAllowingAccessFromCompute(ALLOWING_ACCESS_FROM_COMPUTE_EDEFAULT);
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
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__REQUIRED_SWAP_IMAGE_COUNT:
				return requiredSwapImageCount != REQUIRED_SWAP_IMAGE_COUNT_EDEFAULT;
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__SWAP_IMAGE_USAGES:
				return swapImageUsages != null && !swapImageUsages.isEmpty();
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__ATACHMENTS:
				return atachments != null && !atachments.isEmpty();
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__PRESENT_WHEN_VBLANK:
				return presentWhenVBlank != PRESENT_WHEN_VBLANK_EDEFAULT;
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__ACQUIRE_WAIT_FOR_VBLANK:
				return acquireWaitForVBlank != ACQUIRE_WAIT_FOR_VBLANK_EDEFAULT;
			case GraphicPackage.SWAPCHAIN_CONFIGURATION__ALLOWING_ACCESS_FROM_COMPUTE:
				return allowingAccessFromCompute != ALLOWING_ACCESS_FROM_COMPUTE_EDEFAULT;
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
		result.append(" (requiredSwapImageCount: ");
		result.append(requiredSwapImageCount);
		result.append(", swapImageUsages: ");
		result.append(swapImageUsages);
		result.append(", presentWhenVBlank: ");
		result.append(presentWhenVBlank);
		result.append(", acquireWaitForVBlank: ");
		result.append(acquireWaitForVBlank);
		result.append(", allowingAccessFromCompute: ");
		result.append(allowingAccessFromCompute);
		result.append(')');
		return result.toString();
	}

} //SwapchainConfigurationImpl
