/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.ecore.EClass;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageBarrier;

import org.sheepy.vulkan.model.barrier.impl.AbstractImageBarrierImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Swap Image Barrier</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SwapImageBarrierImpl extends AbstractImageBarrierImpl implements SwapImageBarrier
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwapImageBarrierImpl()
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
		return GraphicPackage.Literals.SWAP_IMAGE_BARRIER;
	}

} //SwapImageBarrierImpl
